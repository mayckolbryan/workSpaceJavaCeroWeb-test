/**
 * 
 */
package com.mitocode.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.mitocode.model.entity.Specialty;
import com.mitocode.service.ISpecialtyService;
import com.mitocode.util.Message;

/**
 * @author mbreyes
 *
 */
@Named
@ViewScoped
public class specialtyController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ISpecialtyService specialtyService;

	private Specialty specialty;
	private Specialty specialtySelec;
	private List<Specialty> specialties;

	@PostConstruct
	public void init() {
		specialty = new Specialty();
		specialtySelec = new Specialty();
		loadSpecialties();
	}

	public void loadSpecialties() {
		try {
			this.specialties = specialtyService.findAll();
		} catch (Exception e) {
			Message.messageError("Error Specialty :" + e.getMessage());
		}
	}

	public void saveSpecialty() {
		try {
			if (specialty.getId() != null) {

				Message.messageInfo("Registro actualizado exitosamente");
				specialtyService.update(specialty);
			} else {
				specialtyService.insert(specialty);
				Message.messageInfo("Registro guardado exitosamente");

			}
			loadSpecialties();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Specialty :" + e.getStackTrace());
		}
	}

	public void editSpecialty() {
		try {
			if (this.specialtySelec != null) {
				this.specialty = specialtySelec;
			} else {
				Message.messageInfo("Debe seleccionar una especialidad");
			}
		} catch (Exception e) {
			Message.messageError("Error Specialty :" + e.getMessage());
		}

	}

	public void selectSpecialty(SelectEvent e) {
		this.specialtySelec = (Specialty) e.getObject();
	}

	public void clearForm() {
		this.specialty = new Specialty();
		this.specialtySelec = null;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	public Specialty getSpecialtySelec() {
		return specialtySelec;
	}

	public void setSpecialtySelec(Specialty specialtySelec) {
		this.specialtySelec = specialtySelec;
	}

	public List<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(List<Specialty> specialties) {
		this.specialties = specialties;
	}
}
