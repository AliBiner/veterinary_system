package com.alibiner.dtos.response.appointment.service;

import java.util.*;
import com.alibiner.dtos.response.BaseResponseDto;

import java.time.LocalDateTime;


public class AppointmentResponseDto implements BaseResponseDto {
    private UUID id;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;

    public AppointmentResponseDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }
}
