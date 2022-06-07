package com.sdm.Project.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"diagnostics", "patient"})
@ToString(exclude = {"patient", "diagnostics"})
public class ClinicalRecord {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Patient patient;
    @OneToMany(mappedBy = "clinicalRecord", cascade = CascadeType.REMOVE)
    private Set<Diagnosis> diagnostics = new HashSet<>();

    public void addDiagnostics(Diagnosis diagnosis){
        diagnostics.add(diagnosis);
        diagnosis.setClinicalRecord(this);
    }

    public void removeDiagnostics(Diagnosis diagnosis){
        diagnostics.remove(diagnosis);
        diagnosis.setClinicalRecord(null);
    }

    public ClinicalRecord(Patient patient) {
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<Diagnosis> getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(Set<Diagnosis> diagnostics) {
        this.diagnostics = diagnostics;
    }

}
