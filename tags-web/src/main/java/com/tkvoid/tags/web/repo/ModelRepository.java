package com.tkvoid.tags.web.repo;

import com.tkvoid.tags.web.bean.po.ModelPo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelPo, Long> {

    ModelPo findByTagId(Long tagId);
}
