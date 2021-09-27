package com.springboot.example.springbooteventdemo.listener;

import com.springboot.example.springbooteventdemo.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/**
 * 通过@EventListener注解实现事件监听
 * 创建MyListener4类，该类无需实现ApplicationListener接口，使用@EventListener装饰具体方法
 */
@Component
@Slf4j
public class MyListener4{
    @EventListener
    public void listener(MyEvent event){
        log.info(String.format("%s监听到事件源：%s.", MyListener4.class.getName(), event.getSource()));
    }
}
