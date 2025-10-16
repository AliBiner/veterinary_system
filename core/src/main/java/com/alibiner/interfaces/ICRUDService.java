package com.alibiner.interfaces;


import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import com.alibiner.dtos.response.BaseResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


public interface ICRUDService<D extends BaseRequestDto,
        T extends BaseResponseDto, S extends Specification<?>> {

    T create(D dto);

    T update(D dto);

    void delete(UUID id);

    T getById(UUID id);

    Page<T> getAll(Pageable pageable, S specification);
}
