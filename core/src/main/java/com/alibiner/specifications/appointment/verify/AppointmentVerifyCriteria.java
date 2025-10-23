package com.alibiner.specifications.appointment.verify;

import java.util.*;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;


public class AppointmentVerifyCriteria {

    private UUID doctorId;
    private LocalDateTime appointmentDate;

    public AppointmentVerifyCriteria() {
    }

    public AppointmentVerifyCriteria(@NonNull UUID doctorId, @NonNull LocalDateTime appointmentDate) {
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
