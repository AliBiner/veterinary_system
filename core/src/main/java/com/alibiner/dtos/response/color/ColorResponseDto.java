package com.alibiner.dtos.response.color;

import java.util.*;
import com.alibiner.dtos.response.BaseResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ColorResponseDto extends BaseResponseDto {
    private UUID id;
    private String name;
}
