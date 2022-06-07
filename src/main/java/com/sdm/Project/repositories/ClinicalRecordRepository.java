package com.sdm.Project.repositories;

import com.sdm.Project.domain.ClinicalRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClinicalRecordRepository extends CrudRepository<ClinicalRecord, Long> {

}
