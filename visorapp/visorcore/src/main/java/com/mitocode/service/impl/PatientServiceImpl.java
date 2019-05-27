/**
 * 
 */
package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.mitocode.model.entity.Patient;
import com.mitocode.model.repository.IPatientRepository;
import com.mitocode.service.IPatientService;

/**
 * @author mbreyes
 *
 */
@Named
public class PatientServiceImpl implements IPatientService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPatientRepository patientRepository;

	@Transactional
	@Override
	public Integer insert(Patient t) throws Exception {
		return patientRepository.insert(t);
	}

	@Transactional
	@Override
	public Integer update(Patient t) throws Exception {
		return patientRepository.update(t);
	}

	@Transactional
	@Override
	public Integer delete(Patient t) throws Exception {
		return patientRepository.delete(t);
	}

	@Override
	public List<Patient> findAll() throws Exception {
		return patientRepository.findAll();
	}

	@Override
	public Patient findById(Patient t) throws Exception {
		return patientRepository.findById(t);
	}

	@Override
	public Optional<Patient> findPatientByDni(String dni) throws Exception {
		return patientRepository.findByDni(dni);
	}

}
