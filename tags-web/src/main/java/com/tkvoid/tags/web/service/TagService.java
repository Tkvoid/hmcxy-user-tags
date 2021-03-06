package com.tkvoid.tags.web.service;

import com.tkvoid.tags.web.bean.dto.ModelDto;
import com.tkvoid.tags.web.bean.dto.TagDto;
import com.tkvoid.tags.web.bean.dto.TagModelDto;

import java.util.List;

public interface TagService {
    void saveTags(List<TagDto> tags);

    List<TagDto> findByPid(Long pid);

    List<TagDto> findByLevel(Integer level);

    void addTagModel(TagDto tag, ModelDto model);


    List<TagModelDto> findModelByPid(Long pid);

    void addDataTag(TagDto tagDto);

    void updateModelState(Long id, Integer state);
}
