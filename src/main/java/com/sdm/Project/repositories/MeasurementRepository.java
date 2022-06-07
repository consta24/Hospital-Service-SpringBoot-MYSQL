package com.sdm.Project.repositories;

import com.sdm.Project.domain.Measurement;
import org.springframework.data.repository.CrudRepository;

public interface MeasurementRepository extends CrudRepository<Measurement, Long> {
}
