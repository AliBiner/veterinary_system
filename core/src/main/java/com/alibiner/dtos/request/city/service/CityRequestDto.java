package com.alibiner.dtos.request.city.service;


import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CityRequestDto extends BaseRequestDto {
    private UUID id;
    private String name;

}
