package com.alibiner.services.user.doctor;

import java.util.*;
import com.alibiner.dtos.response.availableDate.AvailableDateResponseDto;
import com.alibiner.interfaces.availableDate.IAvailableDateService;
import com.alibiner.interfaces.user.doctor.IDoctorService;
import com.alibiner.interfaces.user.doctor.IDoctorVerificationService;
import com.alibiner.specifications.availableDate.AvailableDateSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DoctorService implements IDoctorService {

    private final IDoctorVerificationService IDoctorVerificationService;
    private final IAvailableDateService availableDateService;

    public DoctorService(IDoctorVerificationService IDoctorVerificationService, IAvailableDateService availableDateService) {
        this.IDoctorVerificationService = IDoctorVerificationService;
        this.availableDateService = availableDateService;
    }

    @Override
    public Page<AvailableDateResponseDto> getAllAvailableDate(UUID id, AvailableDateSpecification specification, Pageable pageable) {
        IDoctorVerificationService.verifyDoctor(id);
        return availableDateService.getAll(pageable, specification);
    }
}
