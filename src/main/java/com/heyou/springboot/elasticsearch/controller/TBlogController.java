package com.heyou.springboot.elasticsearch.controller;

import com.heyou.springboot.elasticsearch.entity.TBlog;
import com.heyou.springboot.elasticsearch.service.TBlogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TBlog)表控制层
 *
 * @author heyou
 * @date 2020-03-01 19:33:36
 */
@RestController
@RequestMapping("tBlog")
public class TBlogController {
    /**
     * 服务对象
     */
    @Resource
    private TBlogService tBlogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TBlog selectOne(Integer id) {
        return this.tBlogService.queryById(id);
    }

}