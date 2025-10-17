package com.alibiner.mappers.service.customer;


import com.alibiner.dtos.request.user.UserRequestDto;
import com.alibiner.dtos.response.user.UserResponseDto;
import com.alibiner.entities.User;

public class CustomerMapper {

    public static UserResponseDto toUserResponseDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getPhone(),
                user.getMail(),
                user.getAddress(),
                user.getCity().getName(),
                user.getUserType()
        );
    }

    public static User toUser(UserRequestDto dto) {
        if (dto.getId() == null)
            return new User(
                dto.getName(),
                dto.getPhone(),
                dto.getMail(),
                    dto.getAddress(),
                    dto.getUserType()
            );
        else
            return new User(
                    dto.getId(),
                    dto.getName(),
                    dto.getPhone(),
                    dto.getMail(),
                    dto.getAddress(),
                    dto.getUserType()
            );
    }


}
