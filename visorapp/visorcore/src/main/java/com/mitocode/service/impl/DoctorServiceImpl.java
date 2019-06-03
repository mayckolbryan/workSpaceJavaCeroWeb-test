/**
 * 
 */
package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.mitocode.dto.ReportDoctorSpecialty;
import com.mitocode.model.entity.Doctor;
import com.mitocode.model.repository.IDoctorRepository;
import com.mitocode.service.IDoctorService;

/**
 * @author mbreyes
 *
 */
@Named
public class DoctorServiceImpl implements IDoctorService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDoctorRepository doctorRepository;

	@Transactional
	@Override
	public Integer insert(Doctor t) throws Exception {
		return doctorRepository.insert(t);
	}

	@Transactional
	@Override
	public Integer update(Doctor t) throws Exception {
		return doctorRepository.update(t);
	}

	@Transactional
	@Override
	public Integer delete(Doctor t) throws Exception {
		return doctorRepository.delete(t);
	}

	@Override
	public List<Doctor> findAll() throws Exception {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor findById(Doctor t) throws Exception {
		return doctorRepository.findById(t);
	}

	@Override
	public Doctor findByDni(Doctor t) throws Exception{
		return doctorRepository.findByDni(t);
	}

	@Override
	public List<ReportDoctorSpecialty> reportDoctorsForSpecialties() {
		return doctorRepository.reportDoctorsForSpecialties();
	}

}
