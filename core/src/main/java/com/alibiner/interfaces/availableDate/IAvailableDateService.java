package com.alibiner.interfaces.availableDate;

import java.util.*;
import com.alibiner.dtos.response.availableDate.AvailableDateResponseDto;
import com.alibiner.entities.AvailableDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public interface IAvailableDateService {

    void create(UUID doctorId, HashSet<LocalDate> dtoList);

    void update(UUID doctorId, HashMap<UUID, LocalDate> dtoList);

    void delete(UUID id);

    void deleteAll(HashSet<UUID> id);

//    AvailableDateResponseDto getById(UUID id);

    Page<AvailableDateResponseDto> getAll(Pageable pageable, Specification<AvailableDate> specification);
}
