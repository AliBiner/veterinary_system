package com.alibiner.interfaces.city;


import com.alibiner.dtos.request.city.service.CityRequestDto;
import com.alibiner.dtos.response.city.CityResponseDto;
import com.alibiner.interfaces.ICRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService extends ICRUDService<CityRequestDto, CityResponseDto, Long> {

    Page<CityResponseDto> getByName(String name, Pageable pageable);
}
