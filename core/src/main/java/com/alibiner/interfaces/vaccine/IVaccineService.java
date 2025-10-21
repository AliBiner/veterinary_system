package com.alibiner.interfaces.vaccine;

import java.util.*;
import com.alibiner.dtos.request.vaccine.service.VaccineBaseRequestDto;
import com.alibiner.dtos.response.vaccine.service.VaccineResponseDto;
import com.alibiner.entities.Vaccine;
import com.alibiner.interfaces.ICRUDService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

public interface IVaccineService extends ICRUDService<VaccineBaseRequestDto, VaccineResponseDto, Specification<Vaccine>> {
    void setStatus(@NonNull UUID id, @NonNull Boolean status);
}
