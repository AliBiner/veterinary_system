package com.alibiner.services.user.doctor;

import java.util.*;
import com.alibiner.dtos.response.availableDate.AvailableDateResponseDto;
import com.alibiner.entities.AvailableDate;
import com.alibiner.exceptions.NotAvailable;
import com.alibiner.interfaces.availableDate.IAvailableDateService;
import com.alibiner.interfaces.user.doctor.IDoctorAvailabilityService;
import com.alibiner.interfaces.user.doctor.IDoctorService;
import com.alibiner.interfaces.user.doctor.IDoctorVerificationService;
import com.alibiner.specifications.availableDate.verify.AvailableDateVerifyCriteria;
import com.alibiner.specifications.availableDate.verify.AvailableDateVerifySpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DoctorService implements IDoctorService, IDoctorAvailabilityService {

    private final IDoctorVerificationService IDoctorVerificationService;
    private final IAvailableDateService availableDateService;

    public DoctorService(IDoctorVerificationService IDoctorVerificationService, IAvailableDateService availableDateService) {
        this.IDoctorVerificationService = IDoctorVerificationService;
        this.availableDateService = availableDateService;
    }

    @Override
    public Page<AvailableDateResponseDto> getAllAvailableDate(UUID id, Specification<AvailableDate> specification, Pageable pageable) {
        IDoctorVerificationService.verify(id);
        return availableDateService.getAll(pageable, specification);
    }

    @Override
    public void availabilityDoctor(UUID doctorId, LocalDate appointmentDate) {
        AvailableDateVerifyCriteria criteria = new AvailableDateVerifyCriteria(doctorId, appointmentDate);
        Specification<AvailableDate> specification = new AvailableDateVerifySpecification(criteria);
        Page<AvailableDateResponseDto> availableDates = getAllAvailableDate(doctorId, specification, Pageable.unpaged());

        if (availableDates.isEmpty())
            throw new NotAvailable(NotAvailable.DOCTOR);
    }

}
