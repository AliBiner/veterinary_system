package com.alibiner.dtos.response.appointment.service;

import java.util.*;
import com.alibiner.dtos.response.animal.service.AnimalResponseDto;
import com.alibiner.dtos.response.user.UserResponseDto;
import com.alibiner.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AppointmentDetailResponseDto {
    private UUID id;
    private UserResponseDto doctor;
    private AnimalResponseDto animal;
    private UserResponseDto owner;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private String companionName;
    private AppointmentStatus status;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
