package com.springboot.example.springbooteventdemo.event;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source)
    {
        super(source);
    }
}
