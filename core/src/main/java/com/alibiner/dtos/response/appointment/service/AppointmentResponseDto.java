package com.alibiner.dtos.response.appointment.service;

import java.util.*;
import com.alibiner.dtos.response.BaseResponseDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponseDto implements BaseResponseDto {
    private UUID id;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
}
