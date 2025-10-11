package com.alibiner.config.modelMapper;

import org.modelmapper.ModelMapper;

public interface IModelMapperService {
    ModelMapper forResponse();

    ModelMapper forRequest();
}
