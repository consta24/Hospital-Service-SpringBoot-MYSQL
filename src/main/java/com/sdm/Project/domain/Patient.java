package com.sdm.Project.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"doctor", "clinicalRecord", "nurse"})
@ToString(exclude = {"doctor", "clinicalRecord", "nurse"})
public class Patient extends Person {

    @Id
    @GeneratedValue
    private long id;
    private boolean insurance;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @OneToOne(mappedBy = "patient")
    private ClinicalRecord clinicalRecord;

    public ClinicalRecord getClinicalRecord() {
        return clinicalRecord;
    }

    public void setClinicalRecord(ClinicalRecord clinicalRecord) {
        this.clinicalRecord = clinicalRecord;
    }

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="nurse_id")
    private Nurse nurse;
    public Patient(String name, String gender, int age, Address address, boolean insurance) {
        super(name, gender, age, address);
        this.insurance = insurance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", insurance=" + insurance +
                "} " + super.toString();
    }
}
