/**
 * 
 */
package com.mitocode.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mitocode.model.entity.Specialty;
import com.mitocode.model.repository.ISpecialtyRepository;

/**
 * @author BRYAN
 *
 */
public class SpecialtyRepositoryImpl implements ISpecialtyRepository, Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	@Override
	public Integer insert(Specialty t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Specialty t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Specialty t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Specialty> findAll() throws Exception {
		List<Specialty> specialties = new ArrayList<>();

		TypedQuery<Specialty> query = em.createQuery("SELECT c FROM Specialty c", Specialty.class);
		specialties = query.getResultList();
		return specialties;
	}

	@Override
	public Specialty findById(Specialty t) throws Exception {
		List<Specialty> specialties = new ArrayList<>();
		TypedQuery<Specialty> query = em.createQuery("SELECT c FROM Specialty c WHERE c.id = ?1", Specialty.class);
		query.setParameter(1, t.getId());

		specialties = query.getResultList();

		return specialties != null && !specialties.isEmpty() ? specialties.get(0) : new Specialty();
	}

}
