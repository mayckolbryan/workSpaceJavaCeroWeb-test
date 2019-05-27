/**
 * 
 */
package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.mitocode.model.entity.MedicalConsultation;
import com.mitocode.model.repository.IMedicalConsultationRepository;
import com.mitocode.service.IMedicalConsultationService;

/**
 * @author mbreyes
 *
 */
@Named
public class MedicalConsultationServiceImpl implements IMedicalConsultationService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IMedicalConsultationRepository medicalConsultationRepository;

	@Transactional
	@Override
	public Integer insert(MedicalConsultation t) throws Exception {
		
		t.getItems().forEach(item -> item.setMedicalConsultationId(t));

		return medicalConsultationRepository.insert(t);
	}

	@Transactional
	@Override
	public Integer update(MedicalConsultation t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Integer delete(MedicalConsultation t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalConsultation> findAll() throws Exception {
		return medicalConsultationRepository.findAll();
	}

	@Override
	public MedicalConsultation findById(MedicalConsultation t) throws Exception {
		return medicalConsultationRepository.findById(t);
	}

	@Override
	public MedicalConsultation findByFilters(MedicalConsultation t) throws Exception {
		return medicalConsultationRepository.findByFilters(t);
	}
	
}
