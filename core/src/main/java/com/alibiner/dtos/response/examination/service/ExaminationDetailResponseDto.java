package com.alibiner.dtos.response.examination.service;

import java.util.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
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
}
