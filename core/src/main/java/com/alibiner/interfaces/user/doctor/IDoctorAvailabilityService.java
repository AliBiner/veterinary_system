package com.alibiner.interfaces.user.doctor;

import java.util.*;

import java.time.LocalDate;

public interface IDoctorAvailabilityService {
    void availabilityDoctor(UUID doctorId, LocalDate appointmentDate);
}
