/**
 * 
 */
package com.mitocode.service;

import com.mitocode.model.entity.MedicalConsultation;

/**
 * @author mbreyes
 *
 */
public interface IMedicalConsultationService extends CrudService<MedicalConsultation>{
	
	MedicalConsultation findByFilters(MedicalConsultation t) throws Exception;
}
