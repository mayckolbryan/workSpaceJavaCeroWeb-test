/**
 * 
 */
package com.mitocode.service;

import java.util.Optional;

import com.mitocode.model.entity.Patient;

/**
 * @author mbreyes
 *
 */
public interface IPatientService extends CrudService<Patient>{

	Optional<Patient> findPatientByDni(String dni) throws Exception;

}
