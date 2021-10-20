package com.tkvoid.tags.web.controller;

import com.tkvoid.tags.web.bean.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagAndModelController {

    /**
     * 123级标签添加
     * @param tags
     */
    @PutMapping("tags/relation")
    public void addTag(@RequestBody List tags) {
        System.out.println(tags);
    }

    /**
     * 123级标签显示
     * @param pid
     * @param level
     * @return
     */
    @GetMapping("tags")
    public HttpResult<List> finTagByPidOrLevel(@RequestParam(required = false) Long pid, @RequestParam(required = false) Integer level){
    }

    /**
     * 四级界面新增标签模型
     *
     * 一个4级标签对应1个模型
     * 标签：标签的名称，标签的规则，标签等级
     * 模型：有Jar包的路径，Jar包的执行计划，Jar包执行的主类，Jar包执行的时候额外的参数
     *
     * @param tagModelDto
     * @return
     */
    @PutMapping("tags/model")


}
