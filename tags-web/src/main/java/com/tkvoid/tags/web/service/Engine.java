package com.tkvoid.tags.web.service;

import com.tkvoid.tags.web.bean.dto.ModelDto;

public interface Engine {

    void startModel(ModelDto modelDto);
    void stopModel(ModelDto modelDto);
}
