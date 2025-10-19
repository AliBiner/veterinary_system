package com.alibiner.veterinary_management_system.controllers;

import com.alibiner.dtos.request.appointment.service.AppointmentRequestDto;
import com.alibiner.dtos.response.appointment.service.AppointmentResponseDto;
import com.alibiner.interfaces.appointment.IAppointmentService;
import com.alibiner.veterinary_management_system.result.Result;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
