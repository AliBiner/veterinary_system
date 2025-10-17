package com.alibiner.dtos.request.user;


import java.util.*;
import com.alibiner.enums.UserType;

public class UserRequestFactory {

    public static UserRequestDto newInstance(UserType source, UUID id,
                                             String name, String phone, String mail, String address, UUID cityId) {

        if (source.name().equals(UserType.CUSTOMER.name()))
            return new UserRequestDto(id, name, phone, mail, address, cityId, UserType.CUSTOMER);
        else if (source.name().equals(UserType.DOCTOR.name())) {
            return new UserRequestDto(id, name, phone, mail, address, cityId, UserType.DOCTOR);
        } else
            throw new IllegalArgumentException(source.name() + " type can not support");

    }

}
