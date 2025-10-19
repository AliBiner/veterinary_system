package com.alibiner.interfaces.user.doctor;

import java.util.*;
import com.alibiner.dtos.response.availableDate.AvailableDateResponseDto;
import com.alibiner.entities.AvailableDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface IDoctorService {
    Page<AvailableDateResponseDto> getAllAvailableDate(UUID id, Specification<AvailableDate> specification, Pageable pageable);
}
