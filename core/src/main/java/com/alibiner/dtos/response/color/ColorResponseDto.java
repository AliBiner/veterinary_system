package com.alibiner.dtos.response.color;

import com.alibiner.dtos.response.BaseResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ColorResponseDto extends BaseResponseDto {
    private long id;
    private String name;
}
