package com.mitocode.model.repository;

import com.mitocode.model.entity.MedicalConsultation;

public interface IMedicalConsultationRepository extends JpaRepository<MedicalConsultation>{

	MedicalConsultation findByFilters(MedicalConsultation t) throws Exception;
}
