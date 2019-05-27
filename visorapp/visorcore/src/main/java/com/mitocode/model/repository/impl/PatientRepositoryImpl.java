/**
 * 
 */
package com.mitocode.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mitocode.model.entity.Patient;
import com.mitocode.model.entity.Specialty;
import com.mitocode.model.repository.IPatientRepository;

/**
 * @author mbreyes
 *
 */
@Named
public class PatientRepositoryImpl implements IPatientRepository, Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	@Override
	public Integer insert(Patient t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Patient t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Patient t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Patient> findAll() throws Exception {
		List<Patient> patients = new ArrayList<>();
		
		TypedQuery<Patient> query = em.createQuery("SELECT p FROM Patient p", Patient.class);
		patients = query.getResultList();
		return patients;
	}

	@Override
	public Patient findById(Patient t) throws Exception {
		List<Patient> patients = new ArrayList<>();
		TypedQuery<Patient> query = em.createQuery("SELECT p FROM Patient p WHERE p.id = ?1", Patient.class);
		query.setParameter(1, t.getId());

		patients = query.getResultList();

		return patients != null && !patients.isEmpty() ? patients.get(0) : new Patient();
	}

	@Override
	public Optional<Patient> findByDni(String dni) throws Exception {
		Patient patient;
		TypedQuery<Patient> patientFound = em.createQuery("Select p from Patient p  WHERE p.dni =?1",
				Patient.class);
		patientFound.setParameter(1, dni);
		patient = patientFound.getSingleResult();

		return Optional.of(patient);
	}

}
