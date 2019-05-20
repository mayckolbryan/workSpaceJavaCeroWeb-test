/**
 * 
 */
package com.mitocode.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author BRYAN
 *
 */
@Entity
@Table(name="patients")
public class Patient implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "firstName", length = 80, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 80, nullable = false)
	private String lastName;

	@Column(name = "dni", length = 8, nullable = false)
	private String dni;

	@Column(name = "numberClinicalHistory", length = 20, nullable = false)
	private String numberClinicalHistory;

	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MedicalConsultation> medicalConsultation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNumberClinicalHistory() {
		return numberClinicalHistory;
	}

	public void setNumberClinicalHistory(String numberClinicalHistory) {
		this.numberClinicalHistory = numberClinicalHistory;
	}
}
