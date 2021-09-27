package com.springboot.example.springbooteventdemo.service;

import com.springboot.example.springbooteventdemo.event.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EventService {
    @Autowired
    private ApplicationContext applicationContext;  //容器事件由容器触发

    public void publishEvent(){
        MyEvent myEvent = new MyEvent("service测试事件.");
        applicationContext.publishEvent(myEvent);
    }
}
