package com.sdm.Project.services;

import com.sdm.Project.domain.ClinicalRecord;
import com.sdm.Project.repositories.ClinicalRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicalRecordServiceImpl implements ClinicalRecordService{
    private final ClinicalRecordRepository clinicalRecordRepository;

    public ClinicalRecordServiceImpl(ClinicalRecordRepository clinicalRecordRepository) {
        this.clinicalRecordRepository = clinicalRecordRepository;
    }

    @Override
    public void saveClinicalRecord(ClinicalRecord cr) {
        clinicalRecordRepository.save(cr);
    }

}
