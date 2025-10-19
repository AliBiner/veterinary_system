package com.alibiner.dtos.request.appointment.service;

import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import com.alibiner.errorMessages.ErrorMessages;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
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
}
