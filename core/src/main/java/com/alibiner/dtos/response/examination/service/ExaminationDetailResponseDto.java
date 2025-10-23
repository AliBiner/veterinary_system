package com.alibiner.dtos.response.examination.service;

import java.util.*;

import java.time.LocalDate;


public class ExaminationDetailResponseDto extends ExaminationResponseDto {
    private String vaccineName;
    private String vaccineCode;
    private String animalName;
    private String doctorName;
    private String ownerName;

    public ExaminationDetailResponseDto(UUID id, UUID vaccineId, UUID appointmentId, LocalDate examinationDate, LocalDate vaccineCycleDate, LocalDate vaccineFlexibleCycleDate) {
        super(id, vaccineId, appointmentId, examinationDate, vaccineCycleDate, vaccineFlexibleCycleDate);
    }

    public ExaminationDetailResponseDto(UUID id, UUID vaccineId, UUID appointmentId, LocalDate examinationDate, LocalDate vaccineCycleDate, LocalDate vaccineFlexibleCycleDate, String vaccineName, String vaccineCode, String animalName, String doctorName, String ownerName) {
        super(id, vaccineId, appointmentId, examinationDate, vaccineCycleDate, vaccineFlexibleCycleDate);
        this.vaccineName = vaccineName;
        this.vaccineCode = vaccineCode;
        this.animalName = animalName;
        this.doctorName = doctorName;
        this.ownerName = ownerName;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineCode() {
        return vaccineCode;
    }

    public void setVaccineCode(String vaccineCode) {
        this.vaccineCode = vaccineCode;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
