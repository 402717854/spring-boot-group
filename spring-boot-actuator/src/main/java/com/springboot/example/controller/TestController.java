package com.springboot.example.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class TestController {

    @RequestMapping("/test")
    public void test(){
        log.info("进行请求调用ing");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("完成请求调用");
    }
    @RequestMapping("/testLog/{msg}")
    public void testLog(@PathVariable(required = true) String msg){
        log.info("进行请求调用ing:{}",msg);
        log.info("完成请求调用:{}",msg);
    }
}
