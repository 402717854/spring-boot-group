package com.springboot.example.springbooteventdemo;

import com.springboot.example.springbooteventdemo.event.MyEvent;
import com.springboot.example.springbooteventdemo.listener.MyListener1;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication
public class ApplicationDemo {

    public static void main(String[] args) {
        //创建一个可执行的spring应用程序
        SpringApplication application = new SpringApplication(ApplicationDemo.class);
        //配置事件监听器
        application.addListeners(new MyListener1());
        //配置应用程序上下文
        ConfigurableApplicationContext context =application.run(args);
        //发布事件
        context.publishEvent(new MyEvent(new Object()));
        //关闭监视器
        context.close();
    }

}
