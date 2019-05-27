/**
 * 
 */
package com.mitocode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

import org.primefaces.event.SelectEvent;

import com.mitocode.model.entity.DetailConsultation;
import com.mitocode.model.entity.Doctor;
import com.mitocode.model.entity.MedicalConsultation;
import com.mitocode.model.entity.Patient;
import com.mitocode.service.IDoctorService;
import com.mitocode.service.IMedicalConsultationService;
import com.mitocode.service.IPatientService;
import com.mitocode.util.Message;

/**
 * @author mbreyes
 *
 */
@Named
@ViewScoped
public class medicalConsultationForPatientController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IMedicalConsultationService medicalConsultationService;

	@Inject
	private IPatientService patientService;
	
	@Inject
	private IDoctorService doctorService;

	private MedicalConsultation medicalConsultation;
	private MedicalConsultation medicalConsultationSel;
	private List<MedicalConsultation> medicalConsultations;

	private DetailConsultation detailConsultation;
	private DetailConsultation detailConsultationSel;
	private List<DetailConsultation> detailConsultations;

	private Patient patient;

	@PostConstruct
	public void init() {
		medicalConsultation = new MedicalConsultation();
		medicalConsultationSel = new MedicalConsultation();
		medicalConsultations = new ArrayList<>();

		detailConsultation = new DetailConsultation();
		detailConsultationSel = new DetailConsultation();
		detailConsultations = new ArrayList<>();

		patient = new Patient();
	}

	public void findPatientByDni() {
		try {

			Optional<Patient> patientExist = patientService.findPatientByDni(patient.getDni());

			if (patientExist.isPresent()) {
				patient = patientExist.get();
			}
		} catch (NoResultException e) {
			Message.messageInfo("Cliente no existe");
			resetForm();
		} catch (Exception e) {
			Message.messageError("Error MedicalConsultation :" + e.getMessage());
		}
	}

//	public void addConsultationToDetail() {
//		detailConsultations.add(detailConsultation);
//		
//		cleanDetailConsultation();
//	}

	public void findMedicalConsultation() {
		try {
			if (patient != null) {
				//TODO Reemplazar Doctor por el de la sesion.
				Doctor doctor = new Doctor();
				doctor.setId(1);
				doctor = doctorService.findById(doctor);
				//-----------------------------------------------
				medicalConsultation.setDoctor(doctor);
				medicalConsultation.setPatient(patient);
//				medicalConsultation.setItems(detailConsultations);

				detailConsultations = medicalConsultationService.findByFilters(medicalConsultation).getItems();

				resetForm();
				cleanDetailConsultation();

				Message.messageInfo("Búsqueda de Consulta Médica");
			} else {
				Message.messageInfo("Debe buscar un paciente");
			}

		} catch (Exception e) {
			Message.messageError("Error MedicalConsultation :" + e.getMessage());
		}
	}

	public void cleanDetailConsultation() {
		this.detailConsultation = new DetailConsultation();
	}

	public void resetForm() {
		this.medicalConsultation = new MedicalConsultation();
		this.medicalConsultationSel = null;
		this.detailConsultations.clear();
		this.patient = new Patient();
	}

	public void selectMedicalConsultation(SelectEvent ev) {
		this.medicalConsultationSel = (MedicalConsultation) ev.getObject();
	}

	public void selectDetailConsultation(SelectEvent ev) {
		this.detailConsultation = (DetailConsultation) ev.getObject();
	}

	public MedicalConsultation getMedicalConsultation() {
		return medicalConsultation;
	}

	public void setMedicalConsultation(MedicalConsultation medicalConsultation) {
		this.medicalConsultation = medicalConsultation;
	}

	public MedicalConsultation getMedicalConsultationSel() {
		return medicalConsultationSel;
	}

	public void setMedicalConsultationSel(MedicalConsultation medicalConsultationSel) {
		this.medicalConsultationSel = medicalConsultationSel;
	}

	public List<MedicalConsultation> getMedicalConsultations() {
		return medicalConsultations;
	}

	public void setMedicalConsultations(List<MedicalConsultation> medicalConsultations) {
		this.medicalConsultations = medicalConsultations;
	}

	public DetailConsultation getDetailConsultation() {
		return detailConsultation;
	}

	public void setDetailConsultation(DetailConsultation detailConsultation) {
		this.detailConsultation = detailConsultation;
	}

	public DetailConsultation getDetailConsultationSel() {
		return detailConsultationSel;
	}

	public void setDetailConsultationSel(DetailConsultation detailConsultationSel) {
		this.detailConsultationSel = detailConsultationSel;
	}

	public List<DetailConsultation> getDetailConsultations() {
		return detailConsultations;
	}

	public void setDetailConsultations(List<DetailConsultation> detailConsultations) {
		this.detailConsultations = detailConsultations;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
