package com.alibiner.veterinary_management_system.controllers;

import java.util.*;
import com.alibiner.dtos.request.appointment.controller.AppointmentSearchRequestDto;
import com.alibiner.dtos.request.appointment.service.AppointmentRequestDto;
import com.alibiner.dtos.response.appointment.service.AppointmentDetailResponseDto;
import com.alibiner.dtos.response.appointment.service.AppointmentResponseDto;
import com.alibiner.dtos.response.appointment.service.GetAllAppointmentResponseDto;
import com.alibiner.entities.Appointment;
import com.alibiner.enums.AppointmentStatus;
import com.alibiner.errorMessages.ErrorMessages;
import com.alibiner.interfaces.appointment.IAppointmentService;
import com.alibiner.specifications.appointment.search.AppointmentSearchCriteria;
import com.alibiner.specifications.appointment.search.AppointmentSearchSpecification;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    private final IAppointmentService appointmentService;

    public AppointmentController(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Result<AppointmentResponseDto>> create(@Valid @RequestBody AppointmentRequestDto request) {
        AppointmentResponseDto result = appointmentService.create(request);
        return ResponseEntity.ok(Result.ok(result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> cancel(@PathVariable(name = "id") UUID id) {
        appointmentService.cancel(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result<AppointmentDetailResponseDto>> getById(@PathVariable(name = "id") UUID id) {
        AppointmentDetailResponseDto result = appointmentService.getById(id);
        return ResponseEntity.ok(Result.ok(result));
    }

    @GetMapping
    public ResponseEntity<Result<Page<GetAllAppointmentResponseDto>>> getAll(@Valid @RequestBody AppointmentSearchRequestDto request, Pageable pageable) {
        if (request.getMinDate().isAfter(request.getMaxDate()))
            throw new IllegalArgumentException(ErrorMessages.ValidationMessages.MIN_DATE_GREATER_MAX_DATE);

        AppointmentSearchCriteria criteria = new AppointmentSearchCriteria(
                request.getDoctorId(),
                request.getAnimalId(),
                request.getOwnerId(),
                request.getMinDate(),
                request.getMaxDate(),
                AppointmentStatus.valueOf(request.getStatus())
        );
        Specification<Appointment> specification = new AppointmentSearchSpecification(criteria);

        Page<GetAllAppointmentResponseDto> result = appointmentService.getAll(pageable, specification);
        return ResponseEntity.ok(Result.ok(result));
    }
}
