/**
 * 
 */
package com.mitocode.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author BRYAN
 *
 */
@Entity
@Table(name = "details_consultations")
public class DetailConsultation implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "diagnostic", length = 200, nullable = false)
	private String diagnostic;

	@Column(name = "treatment", length = 200, nullable = false)
	private String treatment;

	@ManyToOne
	@JoinColumn(name = "medical_consultation_id", nullable = false)
	private MedicalConsultation medicalConsultationId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public MedicalConsultation getMedicalConsultationId() {
		return medicalConsultationId;
	}

	public void setMedicalConsultationId(MedicalConsultation medicalConsultationId) {
		this.medicalConsultationId = medicalConsultationId;
	}
}
