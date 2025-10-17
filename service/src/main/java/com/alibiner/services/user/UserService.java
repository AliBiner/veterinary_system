package com.alibiner.services.user;

import java.util.*;
import com.alibiner.dtos.request.user.UserRequestDto;
import com.alibiner.dtos.response.city.CityResponseDto;
import com.alibiner.dtos.response.user.UserResponseDto;
import com.alibiner.entities.City;
import com.alibiner.entities.User;
import com.alibiner.enums.UserType;
import com.alibiner.exceptions.AlreadyExistException;
import com.alibiner.exceptions.NotFoundException;
import com.alibiner.interfaces.city.ICityService;
import com.alibiner.interfaces.user.IUserService;
import com.alibiner.mappers.service.customer.CustomerMapper;
import com.alibiner.repositories.UserRepository;
import com.alibiner.specifications.user.UserSearchCriteria;
import com.alibiner.specifications.user.UserSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService<UserRequestDto, UserResponseDto, UserSpecification> {

    private final UserRepository userRepository;
    private final ICityService cityService;

    public UserService(UserRepository userRepository, ICityService cityService) {
        this.userRepository = userRepository;
        this.cityService = cityService;
    }

    @Override
    public UserResponseDto create(UserRequestDto dto) {
        validateAlreadyExists(null, dto.getPhone(), dto.getMail(), dto.getUserType());

        CityResponseDto cityResponse = cityService.getById(dto.getCityId());

        City city = new City();
        city.setId(cityResponse.getId());
        city.setName(cityResponse.getName());

        User user = CustomerMapper.toUser(dto);
        user.setCity(city);

        userRepository.save(user);
        return CustomerMapper.toUserResponseDto(user);
    }

    @Override
    public UserResponseDto update(UserRequestDto dto) {
        Optional<User> user = userRepository.findByIdAndIsDeleteFalseAndUserType(dto.getId(), dto.getUserType());

        if (user.isEmpty())
            throw new NotFoundException(dto.getUserType().name() + " not found");

        validateAlreadyExists(dto.getId(), dto.getPhone(), dto.getMail(), dto.getUserType());

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

        return CustomerMapper.toUserResponseDto(user.get());
    }

    @Override
    public void delete(UUID id, @NonNull UserType userType) {
        Optional<User> user = userRepository.findByIdAndIsDeleteFalseAndUserType(id, userType);
        if (user.isEmpty())
            throw new NotFoundException(userType + " not found");

        user.get().setDelete(true);
        userRepository.save(user.get());
    }

    @Override
    public UserResponseDto getById(UUID id, @NonNull UserType userType) {
        Optional<User> user = userRepository.findByIdAndIsDeleteFalseAndUserType(id, userType);
        if (user.isEmpty())
            throw new NotFoundException(userType + " not found");
        return CustomerMapper.toUserResponseDto(user.get());
    }

    @Override
    public Page<UserResponseDto> getAll(Pageable pageable, UserSpecification specification) {
        Page<User> customers = userRepository.findAll(specification, pageable);
        return customers.map(CustomerMapper::toUserResponseDto);
    }

    private void validateAlreadyExists(UUID id, String phone, String mail, UserType userType) {
        UserSpecification specification = new UserSpecification(new UserSearchCriteria(id, null, phone, mail, userType));
        if (userRepository.exists(specification))
            throw new AlreadyExistException(userType + " phone or mail already exists!");

    }


}
