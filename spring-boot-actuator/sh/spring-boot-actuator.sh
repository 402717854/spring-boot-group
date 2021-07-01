#!/bin/sh

#export JAVA_HOME=/usr/java/jdk1.8.0_261-amd64
#export PATH=$JAVA_HOME/bin:$PATH

APP_NAME=spring-boot-actuator
#jar包路径
JAR_PATH='/test/app'
#jar名称
JAR_NAME=spring-boot-actuator-0.0.1-SNAPSHOT.jar
#日志路径
LOG_PATH='/test/logs'
#jar包备份路径
BACK_UP_DIR='/test/backup'
#当前时间
DATE=$(date +"%Y%m%d%H%M%S")
#PID  代表是PID文件
PID=$JAR_NAME\.pid
#SKYWALKING_DIR=/irce/agent/skywalking-agent.jar
#SKYWALKING_SERVICE_NAME=irce-bobcfc-processEngine-service
#SKYWALKING_PATH=10.162.4.104:11800


#使用说明，用来提示输入参数
usage(){
    echo "Usage: sh 执行脚本.sh [start|stop|restart|status|backup]"
    exit 1
}

#备份
backup(){
 echo ">>> start backup... <<<"
 cd $JAR_PATH
 if [ -f $JAR_NAME ];then
   if [ ! -d $BACK_UP_DIR/$APP_NAME ];then
      mkdir -p $BACK_UP_DIR/$APP_NAME
   fi
   cp -r $JAR_NAME $BACK_UP_DIR/$APP_NAME/$JAR_NAME-$DATE
   echo ">>> backup successe! <<<"
   else
   echo ">>> jar is not exist,backup fail! <<<"
 fi
}

 
#检查程序是否在运行
is_exist(){
  pid=`ps -ef|grep $JAR_NAME|grep -v grep|awk '{print $2}' `
  #如果不存在返回1，存在返回0    
  if [ -z "${pid}" ]; then
   return 1
  else
    return 0
  fi
}
 
#启动方法
start(){
  is_exist
  if [ $? -eq "0" ]; then
    echo ">>> $APP_NAME is Already exists PID=${pid} <<<"
  else
   # nohup java -javaagent:$SKYWALKING_DIR -Drocketmq.client.logLevel=warn  -Dskywalking.agent.service_name=$SKYWALKING_SERVICE_NAME -Dskywalking.collector.backend_service=$SKYWALKING_PATH  -Xms8g -Xmx8g -XX:+UseG1GC -XX:G1HeapRegionSize=16m  -XX:NewRatio=4 -XX:+PrintGCTimeStamps -XX:+PrintGCDetails -Xloggc:gc.log -XX:+PrintReferenceGC -jar $JAR_PATH/$JAR_NAME >> $LOG_PATH/$APP_NAME.log 2>&1 &
    nohup java -jar $JAR_PATH/$JAR_NAME >> $LOG_PATH/$APP_NAME.log 2>&1 &
    echo $! > $PID
    echo ">>> start $APP_NAME successed PID=$! <<<"
   fi
  }
 
#停止方法
stop(){
  #is_exist
  pidf=$(cat $PID)

  echo ">>> PID = $pidf begin kill $pidf <<<"
  kill $pidf
  rm -rf $PID
  sleep 20
  is_exist
  if [ $? -eq "0" ]; then
    echo ">>> PID = $pid begin kill -9 $pid  <<<"
    kill -9  $pid
    sleep 2
    echo ">>> $APP_NAME process stopped <<<" 
  else
    echo ">>> $APP_NAME is not running <<<"
  fi 
}
 
#输出运行状态
status(){
  is_exist
  if [ $? -eq "0" ]; then
    echo ">>> $APP_NAME is running PID is ${pid} <<<"
  else
    echo ">>> $APP_NAME is not running <<<"
  fi
}
 
#重启
restart(){
  stop
  start
}
 
#根据输入参数，选择执行对应方法，不输入则执行使用说明
case "$1" in
  "start")
    start
    ;;
  "stop")
    stop
    ;;
  "status")
    status
    ;;
  "restart")
    restart
    ;;
  "backup")
    backup
    ;;
  *)
    usage
    ;;
esac
exit 0

