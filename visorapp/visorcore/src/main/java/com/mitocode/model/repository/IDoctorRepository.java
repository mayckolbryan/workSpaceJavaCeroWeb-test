package com.mitocode.model.repository;

import java.util.List;

import com.mitocode.dto.ReportDoctorSpecialty;
import com.mitocode.model.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor>{
	
	public List<ReportDoctorSpecialty> reportDoctorsForSpecialties();
}
