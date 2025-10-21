package com.alibiner.interfaces.vaccine;

import com.alibiner.dtos.request.vaccine.service.VaccineRequestDto;
import com.alibiner.dtos.response.vaccine.service.VaccineResponseDto;
import com.alibiner.entities.Vaccine;
import com.alibiner.interfaces.ICRUDService;
import org.springframework.data.jpa.domain.Specification;

public interface IVaccineService extends ICRUDService<VaccineRequestDto, VaccineResponseDto, Specification<Vaccine>> {
}
