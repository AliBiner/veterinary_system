package com.alibiner.interfaces.appointment;

import java.util.*;
import com.alibiner.dtos.request.appointment.service.AppointmentRequestDto;
import com.alibiner.dtos.response.appointment.service.AppointmentResponseDto;
import com.alibiner.entities.Appointment;
import com.alibiner.interfaces.ICRUDService;
import org.springframework.data.jpa.domain.Specification;

public interface IAppointmentService extends ICRUDService<AppointmentRequestDto, AppointmentResponseDto, Specification<Appointment>> {
    void cancel(UUID id);

    void complete(UUID id);
}
