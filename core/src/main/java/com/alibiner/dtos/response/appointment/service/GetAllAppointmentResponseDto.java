package com.alibiner.dtos.response.appointment.service;

import java.util.*;
import com.alibiner.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class GetAllAppointmentResponseDto {
    private UUID id;
    private String doctorName;
    private String ownerName;
    private String animalName;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private AppointmentStatus status;
    private String companionName;
}
