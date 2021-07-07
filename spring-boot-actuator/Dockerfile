FROM 192.168.66.10/wys/jdk1.8

#springboot内置tomcat的工作目录
VOLUME /tmp
WORKDIR /

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone

#docker logs解决日志乱码
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8

EXPOSE 8080

ADD spring-boot-actuator-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]