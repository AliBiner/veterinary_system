package com.alibiner.dtos.response.appointment.service;

import java.util.*;
import com.alibiner.dtos.response.animal.service.AnimalResponseDto;
import com.alibiner.dtos.response.user.UserResponseDto;
import com.alibiner.enums.AppointmentStatus;

import java.time.LocalDateTime;

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

    public AppointmentDetailResponseDto(UUID id, UserResponseDto doctor, AnimalResponseDto animal, UserResponseDto owner, LocalDateTime startDate, LocalDateTime finishDate, String companionName, AppointmentStatus status, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.doctor = doctor;
        this.animal = animal;
        this.owner = owner;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.companionName = companionName;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public AppointmentDetailResponseDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserResponseDto getDoctor() {
        return doctor;
    }

    public void setDoctor(UserResponseDto doctor) {
        this.doctor = doctor;
    }

    public AnimalResponseDto getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalResponseDto animal) {
        this.animal = animal;
    }

    public UserResponseDto getOwner() {
        return owner;
    }

    public void setOwner(UserResponseDto owner) {
        this.owner = owner;
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

    public String getCompanionName() {
        return companionName;
    }

    public void setCompanionName(String companionName) {
        this.companionName = companionName;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
