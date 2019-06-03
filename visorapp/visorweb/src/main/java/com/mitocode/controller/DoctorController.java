/**
 * 
 */
package com.mitocode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;
import org.primefaces.event.SelectEvent;

import com.mitocode.model.entity.Doctor;
import com.mitocode.model.entity.Rol;
import com.mitocode.model.entity.Specialty;
import com.mitocode.model.entity.User;
import com.mitocode.service.IDoctorService;
import com.mitocode.service.IRolService;
import com.mitocode.service.ISpecialtyService;
import com.mitocode.util.Message;

/**
 * @author mbreyes
 *
 */
@Named
@ViewScoped
public class DoctorController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDoctorService doctorService;
	
	@Inject
	private ISpecialtyService specialtyService;

	private Doctor doctor;
	private Doctor doctorSelec;
	private List<Doctor> doctors;
	
	private Specialty specialty;
	private List<Specialty> specialties;

	@Inject
	private IRolService rolService;
	private User user;

	@PostConstruct
	public void init() {
		doctor = new Doctor();
		user = new User();
		doctorSelec = new Doctor();
		loadDoctors();
		loadSpecialties();
	}

	public void loadDoctors() {
		try {
			this.doctors = doctorService.findAll();
		} catch (Exception e) {
			Message.messageError("Error Doctor :" + e.getMessage());
		}
	}

	public void loadSpecialties() {
		try {
			this.specialties = specialtyService.findAll();
		} catch (Exception e) {
			Message.messageError("Error Doctor :" + e.getMessage());
		}
	}

	public void saveDoctor() {
		try {
			if (doctor.getId() != null) {
				doctor.setSpecialty(specialty);
//				doctorService.update(doctor);
				
				/*--------------------------------------------------------------*/
				String password = this.user.getPassword();
				String passwordHashed = BCrypt.hashpw(password, BCrypt.gensalt());

				//User
				this.user.setPassword(passwordHashed);
				this.user.setState("A");

				//User<---> Doctor					
				this.doctor.setUser(this.user);
				this.user.setDoctor(this.doctor);
				
				this.doctorService.update(this.doctor);
				
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				doctor.setSpecialty(specialty);
//				doctorService.insert(doctor);
//				Message.messageInfo("Registro guardado exitosamente");
				
				/*--------------------------------------------------------------*/
				String password = this.user.getPassword();
				String passwordHashed = BCrypt.hashpw(password, BCrypt.gensalt());

				//User
				this.user.setPassword(passwordHashed);
				this.user.setState("A");

				//User<---> Doctor					
				this.doctor.setUser(this.user);
				this.user.setDoctor(this.doctor);
				
				this.doctorService.insert(this.doctor);
				
	
				//Roles
				List<Rol> roles = new ArrayList<Rol>();
				int rolId = 2;
				Rol rol = new Rol();
				rol.setId(rolId);
	
				roles.add(rol);
	
				//Roles-->User
				rolService.assignRolesToUser(this.user, roles);
				
				Message.messageInfo("Registro guardado exitosamente");
			}
			loadDoctors();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Doctor :" + e.getStackTrace());
		}
	}

	public void editDoctor() {
		try {
			if (this.doctorSelec != null) {
				this.doctor = doctorSelec;
				this.specialty = doctorSelec.getSpecialty();
			} else {
				Message.messageInfo("Debe seleccionar una especialidad");
			}
		} catch (Exception e) {
			Message.messageError("Error Doctor :" + e.getMessage());
		}

	}

	public void selectDoctor(SelectEvent e) {
		this.doctorSelec = (Doctor) e.getObject();
	}

	public void clearForm() {
		this.doctor = new Doctor();
		this.doctorSelec = null;
		this.user = new User();
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Doctor getDoctorSelec() {
		return doctorSelec;
	}

	public void setDoctorSelec(Doctor doctorSelec) {
		this.doctorSelec = doctorSelec;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	public List<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(List<Specialty> specialties) {
		this.specialties = specialties;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
