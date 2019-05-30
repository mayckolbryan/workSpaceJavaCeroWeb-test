package com.mitocode.dto;

import java.io.Serializable;
import java.util.List;

public class ReportDoctorSpecialty implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String specialty;
	private int quantity;
	private List<String> doctors;
	
	public ReportDoctorSpecialty() {
		super();
	}
	
	public ReportDoctorSpecialty(String specialty, int quantity, List<String> doctors) {
		super();
		this.specialty = specialty;
		this.quantity = quantity;
		this.doctors = doctors;
	}

	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<String> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<String> doctors) {
		this.doctors = doctors;
	}
}
