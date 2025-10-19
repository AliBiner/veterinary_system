package com.alibiner.dtos.request.appointment.controller;

import java.util.*;
import com.alibiner.annotations.ValueOfEnum;
import com.alibiner.enums.AppointmentStatus;
import com.alibiner.errorMessages.ErrorMessages;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
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

}
