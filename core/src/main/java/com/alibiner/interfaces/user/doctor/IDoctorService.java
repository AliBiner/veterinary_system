package com.alibiner.interfaces.user.doctor;

import java.util.*;
import com.alibiner.dtos.response.availableDate.AvailableDateResponseDto;
import com.alibiner.specifications.availableDate.AvailableDateSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDoctorService {
    Page<AvailableDateResponseDto> getAllAvailableDate(UUID id, AvailableDateSpecification specification, Pageable pageable);
}
