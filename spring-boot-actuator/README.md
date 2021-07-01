##优雅关闭服务
       添加依赖:
       <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
       添加配置
        ##开启优雅关闭功能
        management.endpoint.shutdown.enabled=true(默认关闭)
        management.endpoints.web.exposure.include=*
        优雅关机
        post请求 http://localhost:8080/actuator/shutdown   等价于kill pid(程序执行完才完成关机)
        kill -9 pid(直接关闭程序)
        查看服务是否健在(只需添加actuator依赖不用进行配置)
        get请求http://localhost:8080/actuator/health