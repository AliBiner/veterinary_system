package com.alibiner.interfaces.appointment;

import java.util.*;
import com.alibiner.dtos.request.appointment.service.AppointmentRequestDto;
import com.alibiner.dtos.response.appointment.service.AppointmentDetailResponseDto;
import com.alibiner.dtos.response.appointment.service.AppointmentResponseDto;
import com.alibiner.dtos.response.appointment.service.GetAllAppointmentResponseDto;
import com.alibiner.entities.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface IAppointmentService {

    AppointmentResponseDto create(AppointmentRequestDto request);

    void cancel(UUID id);

    AppointmentDetailResponseDto getById(UUID id);

    Page<GetAllAppointmentResponseDto> getAll(Pageable pageable, Specification<Appointment> specification);


}
