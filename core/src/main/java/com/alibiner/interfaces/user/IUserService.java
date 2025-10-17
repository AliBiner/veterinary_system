package com.alibiner.interfaces.user;

import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import com.alibiner.dtos.response.BaseResponseDto;
import com.alibiner.enums.UserType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

public interface IUserService<D extends BaseRequestDto,
        T extends BaseResponseDto, S extends Specification<?>> {

    T create(D dto);

    T update(D dto);

    void delete(UUID id, @NonNull UserType userType);

    T getById(UUID id, @NonNull UserType userType);

    Page<T> getAll(Pageable pageable, S specification);
}
