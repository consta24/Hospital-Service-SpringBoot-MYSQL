package com.sdm.Project.services;

import com.sdm.Project.domain.Doctor;
import com.sdm.Project.domain.Nurse;
import com.sdm.Project.domain.Patient;

public interface MedicalPersonnelService {

    void saveDoctor(Doctor doctor);
    void saveNurse(Nurse nurse);
}
