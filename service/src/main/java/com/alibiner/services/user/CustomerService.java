package com.alibiner.services.user;

import java.util.*;
import com.alibiner.dtos.request.customer.service.CustomerRequestDto;
import com.alibiner.dtos.response.city.CityResponseDto;
import com.alibiner.dtos.response.customer.CustomerResponseDto;
import com.alibiner.entities.City;
import com.alibiner.entities.User;
import com.alibiner.enums.UserType;
import com.alibiner.exceptions.AlreadyExistException;
import com.alibiner.exceptions.NotFoundException;
import com.alibiner.interfaces.user.IUserService;
import com.alibiner.mappers.service.customer.CustomerMapper;
import com.alibiner.repositories.UserRepository;
import com.alibiner.services.city.CityService;
import com.alibiner.specifications.user.UserSearchCriteria;
import com.alibiner.specifications.user.UserSpecification;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Qualifier("customerService")
public class CustomerService implements IUserService<CustomerRequestDto, CustomerResponseDto, UserSpecification> {

    private final UserRepository userRepository;
    private final CityService cityService;

    public CustomerService(UserRepository userRepository, CityService cityService) {
        this.userRepository = userRepository;
        this.cityService = cityService;
    }


    @Override
    public CustomerResponseDto create(CustomerRequestDto dto) {
        UserSpecification specification = new UserSpecification(new UserSearchCriteria(null, dto.getPhone(), dto.getMail()));

        if (userRepository.exists(specification))
            throw new AlreadyExistException("User phone or mail already exists!");

        CityResponseDto cityResponse = cityService.getById(dto.getCityId());

        City city = new City();
        city.setId(cityResponse.getId());
        city.setName(cityResponse.getName());

        User user = CustomerMapper.toUser(dto);
        user.setCity(city);
        user.setUserType(UserType.CUSTOMER);

        userRepository.save(user);
        return CustomerMapper.toCustomerResponseDto(user);
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public CustomerResponseDto getById(UUID id) {
        Optional<User> user = userRepository.findByIdAndIsDeleteFalseAndUserType(id, UserType.CUSTOMER);
        if (user.isEmpty())
            throw new NotFoundException("Customer not found");
        return CustomerMapper.toCustomerResponseDto(user.get());
    }

    @Override
    public Page<CustomerResponseDto> getAll(Pageable pageable, UserSpecification specification) {
        return null;
    }
}
