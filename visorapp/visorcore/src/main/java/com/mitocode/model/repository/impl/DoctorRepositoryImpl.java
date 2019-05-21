/**
 * 
 */
package com.mitocode.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mitocode.model.entity.Doctor;
import com.mitocode.model.repository.IDoctorRepository;

/**
 * @author mbreyes
 *
 */
@Named
public class DoctorRepositoryImpl implements IDoctorRepository, Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	@Override
	public Integer insert(Doctor t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Doctor t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Doctor t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Doctor> findAll() throws Exception {
		List<Doctor> doctors = new ArrayList<>();
		
		TypedQuery<Doctor> query = em.createQuery("SELECT d FROM Doctor d", Doctor.class);
		doctors = query.getResultList();
		return doctors;
	}

	@Override
	public Doctor findById(Doctor t) throws Exception {
		List<Doctor> doctors = new ArrayList<>();
		TypedQuery<Doctor> query = em.createQuery("SELECT d FROM Doctor d WHERE d.id = ?1", Doctor.class);
		query.setParameter(1, t.getId());

		doctors = query.getResultList();

		return doctors != null && !doctors.isEmpty() ? doctors.get(0) : new Doctor();
	}

}
