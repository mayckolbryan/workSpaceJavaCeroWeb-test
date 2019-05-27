/**
 * 
 */
package com.mitocode.model.repository;

import java.util.Optional;

import com.mitocode.model.entity.Patient;

/**
 * @author mbreyes
 *
 */
public interface IPatientRepository extends JpaRepository<Patient>{

	Optional<Patient> findByDni(String dni) throws Exception;
}
