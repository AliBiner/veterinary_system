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
        validateAlreadyExists(null, dto.getPhone(), dto.getMail());

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
        Optional<User> user = userRepository.findByIdAndIsDeleteFalseAndUserType(dto.getId(), UserType.CUSTOMER);

        if (user.isEmpty())
            throw new NotFoundException("Customer not found");


        validateAlreadyExists(dto.getId(), dto.getPhone(), dto.getMail());

        CityResponseDto cityResponse = cityService.getById(dto.getCityId());

        City city = new City();
        city.setId(cityResponse.getId());
        city.setName(cityResponse.getName());

        user.get().setName(dto.getName());
        user.get().setPhone(dto.getPhone());
        user.get().setMail(dto.getMail());
        user.get().setAddress(dto.getAddress());
        user.get().setCity(city);

        userRepository.save(user.get());

        return CustomerMapper.toCustomerResponseDto(user.get());
    }

    @Override
    public void delete(UUID id) {
        Optional<User> user = userRepository.findByIdAndIsDeleteFalseAndUserType(id, UserType.CUSTOMER);
        if (user.isEmpty())
            throw new NotFoundException("Customer not found");

        user.get().setDelete(true);
        userRepository.save(user.get());
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

    private void validateAlreadyExists(UUID id, String phone, String mail) {
        System.out.println(id);
        UserSpecification specification = new UserSpecification(new UserSearchCriteria(id, null, phone, mail, UserType.CUSTOMER));
        if (userRepository.exists(specification))
            throw new AlreadyExistException("User phone or mail already exists!");
    }
}
