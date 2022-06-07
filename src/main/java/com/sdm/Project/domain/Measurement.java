package com.sdm.Project.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "diagnosis")
@ToString(exclude = {"diagnosis"})
public class Measurement {

    @Id
    @GeneratedValue
    private long id;

    private double temperature;
    private int bloodPressure;
    private LocalDate time;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="diagnosis_id")
    private Diagnosis diagnosis;

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Measurement(double temperature, int bloodPressure, LocalDate time) {
        this.temperature = temperature;
        this.bloodPressure = bloodPressure;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }


}
