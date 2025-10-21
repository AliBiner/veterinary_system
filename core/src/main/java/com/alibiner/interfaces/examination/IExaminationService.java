package com.alibiner.interfaces.examination;


import com.alibiner.dtos.request.examination.service.ExaminationRequestDto;
import com.alibiner.dtos.response.examination.service.ExaminationResponseDto;
import com.alibiner.entities.Examination;
import com.alibiner.interfaces.ICRUDService;
import org.springframework.data.jpa.domain.Specification;

public interface IExaminationService extends ICRUDService<ExaminationRequestDto, ExaminationResponseDto, Specification<Examination>> {
}
