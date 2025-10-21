package com.alibiner.mappers.service.vaccine;

import com.alibiner.dtos.request.vaccine.service.VaccineCreateRequestDto;
import com.alibiner.dtos.response.vaccine.service.VaccineResponseDto;
import com.alibiner.entities.Vaccine;

public class VaccineMapper {
    public static Vaccine toVaccine(VaccineCreateRequestDto dto) {
        return new Vaccine(
                dto.getName(),
                dto.getDescription(),
                dto.getCode(),
                dto.getVaccineCycle(),
                dto.getFlexibleCycle()
        );
    }


    public static VaccineResponseDto toVaccineResponseDto(Vaccine entity) {
        VaccineResponseDto dto = new VaccineResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setCode(entity.getCode());
        dto.setVaccineCycle(entity.getVaccineCycle());
        dto.setFlexibleCycle(entity.getFlexibleCycle());
        dto.setActive(entity.isActive());

        return dto;
    }
}
