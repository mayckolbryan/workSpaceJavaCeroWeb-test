/**
 * 
 */
package com.mitocode.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.mitocode.dto.ReportDoctorSpecialty;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<ReportDoctorSpecialty> reportDoctorsForSpecialties() {
		List<ReportDoctorSpecialty> reportDoctorSpecialties = new ArrayList<>();
		try {
			Query query = em.createNativeQuery("SELECT * FROM fn_QuantityDoctorBySpecialty()");
			// query.setParameter(1, per.getIdPersona());
			//IdSpecialty / nameSpecialty / cantidadDoctors
		
			List<Object[]> data = query.getResultList();
			
			/*0) [1, Category 1]
			  1) [2, Category 2]
			  */

			data.forEach(x -> {
				int idSpecialty = Integer.parseInt(String.valueOf(x[0]));
				String specialty = String.valueOf(x[1]);
				int quantity = Integer.parseInt(String.valueOf(x[2]));
				List<String> doctors = new ArrayList<>();

				Query queryDoctors = em.createNativeQuery("SELECT * FROM fn_ListDoctorsBySpecialty(?1)");
				queryDoctors.setParameter(1, idSpecialty);
				List<Object[]> dataDoctors = query.getResultList();
				doctors = dataDoctors.stream().map(doctorObject -> Objects.toString(doctorObject, null))
											  .collect(Collectors.toList());
						
				reportDoctorSpecialties.add(new ReportDoctorSpecialty(specialty, quantity, doctors));
			});

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return reportDoctorSpecialties;
	}

}
