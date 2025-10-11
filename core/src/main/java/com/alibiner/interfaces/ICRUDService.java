package com.alibiner.interfaces;


import com.alibiner.dtos.request.BaseRequestDto;
import com.alibiner.dtos.response.BaseResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICRUDService<D extends BaseRequestDto,
        T extends BaseResponseDto,
        ID extends Number> {

    T create(D dto);

    T update(D dto);

    void delete(ID id);

    T getById(ID id);

    Page<T> getAll(Pageable pageable);
}
