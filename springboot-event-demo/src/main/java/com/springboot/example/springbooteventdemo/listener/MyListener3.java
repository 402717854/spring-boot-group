package com.springboot.example.springbooteventdemo.listener;

import com.springboot.example.springbooteventdemo.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * 在application.properties中配置监听
 */
@Slf4j
public class MyListener3 implements ApplicationListener<MyEvent> {

    public void onApplicationEvent(MyEvent event){
        log.info(String.format("%s监听到事件源：%s.", MyListener3.class.getName(), event.getSource()));
    }
}
