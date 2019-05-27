package com.mitocode.model.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mitocode.model.entity.MedicalConsultation;
import com.mitocode.model.entity.Status;
import com.mitocode.model.repository.IMedicalConsultationRepository;

@Named
public class MedicalConsultationRepositoryImpl implements IMedicalConsultationRepository, Serializable{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	@Override
	public Integer insert(MedicalConsultation t) throws Exception {
		t.setState(Status.ISSUED.getCodeStatus());
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(MedicalConsultation t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(MedicalConsultation t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalConsultation> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicalConsultation findById(MedicalConsultation t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
