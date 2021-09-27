package com.springboot.example.springbooteventdemo.listener;

import com.springboot.example.springbooteventdemo.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;


/**
 * 手工向ApplicationContext中添加监听器
 */
@Slf4j
public class MyListener1 implements ApplicationListener<MyEvent> {


    public void onApplicationEvent(MyEvent event){
        log.info(String.format("%s监听到事件源：%s.", MyListener1.class.getName(), event.getSource()));
    }
}
