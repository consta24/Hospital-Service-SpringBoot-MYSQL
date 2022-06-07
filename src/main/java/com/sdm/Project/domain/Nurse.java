package com.sdm.Project.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "patientSet")
@ToString(exclude = "patientSet")
public class Nurse{
    @Id
    @GeneratedValue
    private long id;
    private int floor;

    public Nurse(int floor) {
        this.floor = floor;
    }

    @OneToMany(mappedBy = "nurse", cascade = CascadeType.REMOVE)
    private Set<Patient> patientSet = new HashSet<>();
    public void addPatient(Patient patient){
        patientSet.add(patient);
        patient.setNurse(this);
    }
    public void removePatient(Patient patient){
        patientSet.remove(patient);
        patient.setNurse(null);
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Patient> getPatientSet() {
        return patientSet;
    }

    public void setPatientSet(Set<Patient> patientSet) {
        this.patientSet = patientSet;
    }


}
