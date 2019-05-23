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

import com.mitocode.model.entity.Patient;
import com.mitocode.service.IPatientService;
import com.mitocode.util.Message;

/**
 * @author mbreyes
 *
 */
@Named
@ViewScoped
public class patientController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPatientService patientService;

	private Patient patient;
	private Patient patientSelec;
	private List<Patient> patients;

	@PostConstruct
	public void init() {
		patient = new Patient();
		patientSelec = new Patient();
		loadPatients();
	}

	public void loadPatients() {
		try {
			this.patients = patientService.findAll();
		} catch (Exception e) {
			Message.messageError("Error Patient :" + e.getMessage());
		}
	}

	public void savePatient() {
		try {
			if (patient.getId() != null) {

				Message.messageInfo("Registro actualizado exitosamente");
				patientService.update(patient);
			} else {
				patientService.insert(patient);
				Message.messageInfo("Registro guardado exitosamente");

			}
			loadPatients();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Patient :" + e.getStackTrace());
		}
	}

	public void editPatient() {
		try {
			if (this.patientSelec != null) {
				this.patient = patientSelec;
			} else {
				Message.messageInfo("Debe seleccionar una especialidad");
			}
		} catch (Exception e) {
			Message.messageError("Error Patient :" + e.getMessage());
		}

	}

	public void selectPatient(SelectEvent e) {
		this.patientSelec = (Patient) e.getObject();
	}

	public void clearForm() {
		this.patient = new Patient();
		this.patientSelec = null;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Patient getPatientSelec() {
		return patientSelec;
	}

	public void setPatientSelec(Patient patientSelec) {
		this.patientSelec = patientSelec;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
}
