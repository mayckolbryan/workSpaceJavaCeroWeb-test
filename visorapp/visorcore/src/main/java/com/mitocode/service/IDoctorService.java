/**
 * 
 */
package com.mitocode.service;

import java.util.List;

import com.mitocode.dto.ReportDoctorSpecialty;
import com.mitocode.model.entity.Doctor;

/**
 * @author mbreyes
 *
 */
public interface IDoctorService extends CrudService<Doctor>{

	public List<ReportDoctorSpecialty> reportDoctorsForSpecialties();
	
	public Doctor findByDni(Doctor t) throws Exception;
}
