package com.alibiner.mappers.service.examination;


import com.alibiner.dtos.response.examination.service.ExaminationDetailResponseDto;
import com.alibiner.dtos.response.examination.service.ExaminationResponseDto;
import com.alibiner.entities.Examination;

public class ExaminationMapper {

    public static ExaminationResponseDto toExaminationResponseDto(Examination entity) {
        return new ExaminationResponseDto(entity.getId(),
                entity.getVaccine().getId(),
                entity.getAppointment().getId(),
                entity.getExaminationDate(),
                entity.getVaccineCycleDate(),
                entity.getVaccineFlexibleDate());
    }

    public static ExaminationDetailResponseDto toExaminationDetailResponseDto(Examination entity) {
        return new ExaminationDetailResponseDto(
                entity.getId(),
                entity.getVaccine().getId(),
                entity.getAppointment().getId(),
                entity.getExaminationDate(),
                entity.getVaccineCycleDate(),
                entity.getVaccineFlexibleDate(),
                entity.getVaccine().getName(),
                entity.getVaccine().getCode(),
                entity.getAppointment().getAnimal().getName(),
                entity.getAppointment().getDoctor().getName(),
                entity.getAppointment().getAnimal().getUser().getName()
        );

    }
}
