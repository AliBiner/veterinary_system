package com.alibiner.interfaces.animal;


import com.alibiner.dtos.request.animal.service.AnimalRequestDto;
import com.alibiner.dtos.response.animal.service.AnimalResponseDto;
import com.alibiner.interfaces.ICRUDService;
import com.alibiner.specifications.animal.AnimalSpecification;

public interface IAnimalService extends ICRUDService<AnimalRequestDto, AnimalResponseDto, AnimalSpecification> {
}
