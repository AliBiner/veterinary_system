package com.alibiner.dtos.response.appointment.service;

import java.util.*;
import com.alibiner.enums.AppointmentStatus;

import java.time.LocalDateTime;

public class GetAllAppointmentResponseDto {
    private UUID id;
    private String doctorName;
    private String ownerName;
    private String animalName;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private AppointmentStatus status;
    private String companionName;

    public GetAllAppointmentResponseDto(UUID id, String doctorName, String ownerName, String animalName, LocalDateTime startDate, LocalDateTime finishDate, AppointmentStatus status, String companionName) {
        this.id = id;
        this.doctorName = doctorName;
        this.ownerName = ownerName;
        this.animalName = animalName;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.status = status;
        this.companionName = companionName;
    }

    public UUID getId() {
        return id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getAnimalName() {
        return animalName;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public String getCompanionName() {
        return companionName;
    }
}
