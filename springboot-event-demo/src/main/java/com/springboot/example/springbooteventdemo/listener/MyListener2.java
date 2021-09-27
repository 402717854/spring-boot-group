package com.springboot.example.springbooteventdemo.listener;

import com.springboot.example.springbooteventdemo.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 创建MyListener2类，并使用@Component注解将该类装载入spring容器中
 */
@Component
@Slf4j
public class MyListener2 implements ApplicationListener<MyEvent> {

    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s监听到事件源：%s.", MyListener2.class.getName(), event.getSource()));
    }
}
