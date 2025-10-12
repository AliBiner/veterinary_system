package com.alibiner.interfaces.city;


import com.alibiner.dtos.request.city.service.CityRequestDto;
import com.alibiner.dtos.response.city.CityResponseDto;
import com.alibiner.interfaces.ICRUDService;
import com.alibiner.specifications.city.CitySpecification;

public interface ICityService extends ICRUDService<CityRequestDto, CityResponseDto, CitySpecification> {

//    Page<CityResponseDto> getByName(String name, Pageable pageable);

}
