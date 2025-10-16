package com.alibiner.interfaces.user;

import com.alibiner.dtos.request.BaseRequestDto;
import com.alibiner.dtos.response.BaseResponseDto;
import com.alibiner.interfaces.ICRUDService;
import org.springframework.data.jpa.domain.Specification;

public interface IUserService<D extends BaseRequestDto,
        T extends BaseResponseDto, S extends Specification<?>> extends ICRUDService<D, T, S> {
}
