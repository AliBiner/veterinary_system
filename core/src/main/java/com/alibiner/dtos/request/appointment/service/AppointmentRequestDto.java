package com.alibiner.dtos.request.appointment.service;

import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import com.alibiner.errorMessages.ErrorMessages;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class AppointmentRequestDto implements BaseRequestDto {

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private UUID doctorId;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private UUID animalId;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @FutureOrPresent(message = ErrorMessages.ValidationMessages.DATE_MUST_FUTURE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentDate;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private String companionName;

    public AppointmentRequestDto() {
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public UUID getAnimalId() {
        return animalId;
    }

    public void setAnimalId(UUID animalId) {
        this.animalId = animalId;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getCompanionName() {
        return companionName;
    }

    public void setCompanionName(String companionName) {
        this.companionName = companionName;
    }
}
