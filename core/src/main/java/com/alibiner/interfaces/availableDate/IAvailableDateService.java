package com.alibiner.interfaces.availableDate;

import java.util.*;
import com.alibiner.dtos.response.availableDate.AvailableDateResponseDto;
import com.alibiner.specifications.availableDate.AvailableDateSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface IAvailableDateService {

    void create(UUID doctorId, HashSet<LocalDate> dtoList);

    void update(UUID doctorId, HashMap<UUID, LocalDate> dtoList);

    void delete(UUID id);

    void deleteAll(HashSet<UUID> id);

//    AvailableDateResponseDto getById(UUID id);

    Page<AvailableDateResponseDto> getAll(Pageable pageable, AvailableDateSpecification specification);
}
