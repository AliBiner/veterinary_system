package com.alibiner.dtos.request.city.service;


import com.alibiner.dtos.request.BaseRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CityRequestDto extends BaseRequestDto {
    private Long id;
    private String name;

}
