package com.springboot.example.springbooteventdemo;

import com.springboot.example.springbooteventdemo.event.MyEvent;
import com.springboot.example.springbooteventdemo.listener.MyListener1;
import com.springboot.example.springbooteventdemo.service.EventService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootEventDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootEventDemoApplication.class, args);
        //装载监听
        applicationContext.addApplicationListener(new MyListener1());
        //发布事件
        applicationContext.publishEvent(new MyEvent("测试事件."));
        EventService eventService = (EventService) applicationContext.getBean("eventService");
        eventService.publishEvent();
    }

}
