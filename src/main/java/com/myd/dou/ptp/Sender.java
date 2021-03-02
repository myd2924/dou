package com.myd.dou.ptp;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ClassName Sender
 * @Description productor
 * @Author 18050909
 * @Date 2020/4/23 22:46
 * @Version 1.0
 **/
public class Sender {
    public static void main(String[] args) {
        //定义一个连接工厂
        ActiveMQConnectionFactory connectionFactory;
        //定义一个私有连接
        Connection connection = null;
        //session：上下文管理容器
        Session session = null;
        //队列（目的地、生产者发送消息的目的地）
        Queue queue = null;
        //messageProducer:定义消息发送者【生产者】
        MessageProducer messageProducer = null;
        //1.实例化连接工程，这里使用jms的其中一个实现ActionMQ
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD,"tcp://localhost:61616");
        try {
            //2.获取连接对象
            connection = connectionFactory.createConnection();

            //3.启动连接,默认是关闭的
            connection.start();
            //4.创建一个可操作的连接对象（参数1-是否开启事物，参数2-是签收的模式）
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            //5.获取消息目标，就是消息发送和接受的地点（"test_queue1"是定义的一个队列名字）
            queue = session.createQueue("chenxi_queue");
            //6.消息主体，这里比喻成生产者。session进行创建
            messageProducer = session.createProducer(queue);
            //消息过期设置
            //messageProducer.setTimeToLive(1000);
            //7.设置是否持久化方式
            messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            //8.设置发送消息,定义JMS规范的消息类型，这里定义简单的TextMessage,session进行创建,并发送消息
            sendMessage(session,messageProducer);
            session.commit();
            System.out.println("测试消息发送结束！");

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
                if(null !=session) {
                    session.close();
                }
            } catch (Throwable ignore) {
            }

        }

    }

    public static void sendMessage(Session session,MessageProducer messageProducer) throws JMSException {

        for(int i=0;i<5;i++){
            TextMessage message = session.createTextMessage("大曦activeMq发送消息："+i);
            System.out.println("发送消息：" + "ActiveMq 发送的消息" + i);
            messageProducer.send(message);
        }

    }
}
