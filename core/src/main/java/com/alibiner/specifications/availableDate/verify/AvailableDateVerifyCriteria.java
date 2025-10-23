package com.alibiner.specifications.availableDate.verify;

import java.util.*;
import org.springframework.lang.NonNull;

import java.time.LocalDate;


public class AvailableDateVerifyCriteria {
    private UUID doctorId;
    private LocalDate appointmentDate;

    public AvailableDateVerifyCriteria(@NonNull UUID doctorId, @NonNull LocalDate appointmentDate) {
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
    }

    public AvailableDateVerifyCriteria() {
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
