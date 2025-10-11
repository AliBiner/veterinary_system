package com.alibiner.dtos.response.city;

import com.alibiner.dtos.response.BaseResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CityResponseDto extends BaseResponseDto {
    private long id;
    private String name;
}
