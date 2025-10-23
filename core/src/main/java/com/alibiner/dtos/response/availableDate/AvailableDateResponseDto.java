package com.alibiner.dtos.response.availableDate;

import java.util.*;
import com.alibiner.dtos.response.BaseResponseDto;

import java.time.LocalDate;

public class AvailableDateResponseDto implements BaseResponseDto {
    private UUID id;
    private LocalDate availableDate;
    private String doctorName;
    private UUID doctorId;

    public AvailableDateResponseDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }
}
