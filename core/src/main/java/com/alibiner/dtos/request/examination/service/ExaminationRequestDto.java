package com.alibiner.dtos.request.examination.service;

import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import com.alibiner.errorMessages.ErrorMessages;
import jakarta.validation.constraints.NotNull;

public class ExaminationRequestDto implements BaseRequestDto {
    private UUID id;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private UUID appointmentId;

    @NotNull(message = ErrorMessages.ValidationMessages.NOT_NULL)
    private UUID vaccineId;

    public ExaminationRequestDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(UUID appointmentId) {
        this.appointmentId = appointmentId;
    }

    public UUID getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(UUID vaccineId) {
        this.vaccineId = vaccineId;
    }
}
