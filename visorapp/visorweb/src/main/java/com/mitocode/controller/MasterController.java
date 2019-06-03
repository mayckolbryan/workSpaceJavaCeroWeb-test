package com.mitocode.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mitocode.model.entity.User;
import com.mitocode.model.entity.UserRol;
import com.mitocode.service.IRolService;

@Named
@ViewScoped
public class MasterController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IRolService rolService;

	public void checkSesion() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			User user = null;
			if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user") != null &&
					!FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user").equals(null)) {
				user = ((Optional<User>)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user")).get();
			}

			if (user == null) {
				context.getExternalContext().redirect("./../index.xhtml");
			}else {
				
				String viewId = context.getViewRoot().getViewId();
				System.out.println("VIEW ID:"+viewId);
				
				boolean rpta = checkMenu(viewId);
				
				if(!rpta) {
					context.getExternalContext().redirect("./../403.xhtml");
				}
			}	

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean checkMenu(String viewId) {

		try {
			FacesContext context = FacesContext.getCurrentInstance();
			User user = ((Optional<User>)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user")).get();
			
			System.out.println("USER :"+user.toString());

			List<UserRol> userRoles = rolService.findRolesByUser(user);
			
			for (UserRol userRol2 : userRoles) {
				System.out.println("USERROLE: " + userRol2.getUserId().getDoctor().getFirstName() + " " + userRol2.getUserId().getDoctor().getLastName());
			}
			

			String typeRol = "";
			switch (viewId) {
			case "/protected/inicio.xhtml":
				typeRol = "ADMIN,USER";
				break;
			case "/protected/doctors.xhtml":
				typeRol = "ADMIN";
				break;
			case "/protected/specialties.xhtml":
				typeRol = "ADMIN";
				break;
			case "/protected/patients.xhtml":
				typeRol = "ADMIN";
				break;
			case "/protected/rep_doctor_for_specialty.xhtml":
				typeRol = "ADMIN";
				break;
			case "/protected/medicalConsultations.xhtml":
				typeRol = "USER";
				break;
			case "/protected/medicalConsultationsForPatient.xhtml":
				typeRol = "USER";
				break;
			case "/protected/rep_clinic_history.xhtml":
				typeRol = "USER";
				break;

			default:
				break;
			}

			String typeRoles[] = typeRol.split(",");

			int[] count = { 0 };
			userRoles.forEach(userRol -> {
				for (String typeRoleFound : typeRoles) {
					if (userRol.getRolId().getType().equals(typeRoleFound)) {
						count[0]++;
					}
				}
			});

			if (count[0] == 0) {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return true;
	}

	public void signOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

}
