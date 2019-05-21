/**
 * 
 */
package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.mitocode.model.entity.Specialty;
import com.mitocode.model.repository.ISpecialtyRepository;
import com.mitocode.service.ISpecialtyService;

/**
 * @author mbreyes
 *
 */
@Named
public class SpecialtyServiceImpl implements ISpecialtyService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ISpecialtyRepository specialtyRepository;

	@Transactional
	@Override
	public Integer insert(Specialty t) throws Exception {
		return specialtyRepository.insert(t);
	}

	@Transactional
	@Override
	public Integer update(Specialty t) throws Exception {
		return specialtyRepository.update(t);
	}

	@Transactional
	@Override
	public Integer delete(Specialty t) throws Exception {
		return specialtyRepository.delete(t);
	}

	@Override
	public List<Specialty> findAll() throws Exception {
		return specialtyRepository.findAll();
	}

	@Override
	public Specialty findById(Specialty t) throws Exception {
		return specialtyRepository.findById(t);
	}

}
