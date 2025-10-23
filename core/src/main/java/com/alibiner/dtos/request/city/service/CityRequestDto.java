package com.alibiner.dtos.request.city.service;


import java.util.*;
import com.alibiner.dtos.request.BaseRequestDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@NoArgsConstructor
public class CityRequestDto implements BaseRequestDto {
    private UUID id;
    private String name;

}
