package com.alibiner.dtos.response.examination.service;

import java.util.*;
import com.alibiner.dtos.response.BaseResponseDto;

import java.time.LocalDate;

public class ExaminationResponseDto implements BaseResponseDto {
    private UUID id;
    private UUID vaccineId;
    private UUID appointmentId;
    private LocalDate examinationDate;
    private LocalDate vaccineCycleDate;
    private LocalDate vaccineFlexibleCycleDate;

    public ExaminationResponseDto(UUID id, UUID vaccineId, UUID appointmentId, LocalDate examinationDate, LocalDate vaccineCycleDate, LocalDate vaccineFlexibleCycleDate) {
        this.id = id;
        this.vaccineId = vaccineId;
        this.appointmentId = appointmentId;
        this.examinationDate = examinationDate;
        this.vaccineCycleDate = vaccineCycleDate;
        this.vaccineFlexibleCycleDate = vaccineFlexibleCycleDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(UUID vaccineId) {
        this.vaccineId = vaccineId;
    }

    public UUID getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(UUID appointmentId) {
        this.appointmentId = appointmentId;
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

    public LocalDate getVaccineFlexibleCycleDate() {
        return vaccineFlexibleCycleDate;
    }

    public void setVaccineFlexibleCycleDate(LocalDate vaccineFlexibleCycleDate) {
        this.vaccineFlexibleCycleDate = vaccineFlexibleCycleDate;
    }
}
