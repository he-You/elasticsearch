package com.heyou.springboot.elasticsearch.controller;

import com.heyou.springboot.elasticsearch.service.TestService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyou(heyou_0423 @ 163.com)
 * @date 2020/5/21 23:11
 */
@RestController(value = "/test")
@Api(tags = "ES")
public class TestController {
    @Autowired
    private TestService testService;
    @GetMapping("/hello")
    public void hello(){
        testService.saveArticle();
    }
}
