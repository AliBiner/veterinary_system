package com.alibiner.dtos.request.appointment.controller;

import java.util.*;
import com.alibiner.annotations.ValueOfEnum;
import com.alibiner.enums.AppointmentStatus;
import com.alibiner.errorMessages.ErrorMessages;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class AppointmentSearchRequestDto {
    private UUID doctorId;
    private UUID animalId;
    private UUID ownerId;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private LocalDateTime minDate;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private LocalDateTime maxDate;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    @ValueOfEnum(enumClass = AppointmentStatus.class, values = "RESERVED,COMPLETED,CANCELLED")
    private String status;

    public AppointmentSearchRequestDto() {
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

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public LocalDateTime getMinDate() {
        return minDate;
    }

    public void setMinDate(LocalDateTime minDate) {
        this.minDate = minDate;
    }

    public LocalDateTime getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(LocalDateTime maxDate) {
        this.maxDate = maxDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
