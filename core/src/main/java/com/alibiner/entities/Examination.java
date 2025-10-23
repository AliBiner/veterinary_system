package com.alibiner.entities;

import java.util.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "examinations")
public class Examination extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "examination_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vaccine_id", nullable = false)
    private Vaccine vaccine;

    @Column(name = "examination_date", nullable = false)
    @CreationTimestamp
    private LocalDate examinationDate;

    @Column(name = "examination_vaccine_cycle_date")
    private LocalDate vaccineCycleDate;

    @Column(name = "examination_vaccine_flexible_date")
    private LocalDate vaccineFlexibleDate;

    public Examination() {
    }

    public Examination(Appointment appointment, Vaccine vaccine, LocalDate examinationDate) {
        this(appointment, vaccine, examinationDate, null, null);
    }

    public Examination(Appointment appointment, Vaccine vaccine, LocalDate examinationDate, LocalDate vaccineCycleDate) {
        this(appointment, vaccine, examinationDate, vaccineCycleDate, null);
    }

    public Examination(Appointment appointment, Vaccine vaccine, LocalDate examinationDate, LocalDate vaccineCycleDate, LocalDate vaccineFlexibleDate) {
        this.appointment = appointment;
        this.vaccine = vaccine;
        this.examinationDate = examinationDate;
        this.vaccineCycleDate = vaccineCycleDate;
        this.vaccineFlexibleDate = vaccineFlexibleDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public LocalDate getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(LocalDate examinationDate) {
        this.examinationDate = examinationDate;
    }

    public LocalDate getVaccineCycleDate() {
        return vaccineCycleDate;
    }

    public void setVaccineCycleDate(LocalDate vaccineCycleDate) {
        this.vaccineCycleDate = vaccineCycleDate;
    }

    public LocalDate getVaccineFlexibleDate() {
        return vaccineFlexibleDate;
    }

    public void setVaccineFlexibleDate(LocalDate vaccineFlexibleDate) {
        this.vaccineFlexibleDate = vaccineFlexibleDate;
    }

    @Override
    public String toString() {
        return "Examination{" +
                "id=" + id +
                ", appointment=" + appointment +
                ", vaccine=" + vaccine +
                ", examinationDate=" + examinationDate +
                ", vaccineCycleDate=" + vaccineCycleDate +
                ", vaccineFlexibleDate=" + vaccineFlexibleDate +
                '}';
    }
}
