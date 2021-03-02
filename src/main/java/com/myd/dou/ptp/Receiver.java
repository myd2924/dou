package com.myd.dou.ptp;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * @ClassName Receiver
 * @Description 消费
 * @Author 18050909
 * @Date 2020/4/24 16:11
 * @Version 1.0
 **/
public class Receiver {
    public static void main(String[] args) {
        ActiveMQConnectionFactory connectionFactory;
        Connection connection ;
        Session session ;
        Queue queue;
        MessageConsumer messageConsumer ;
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD,"tcp://localhost:61616" );
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            queue = session.createQueue("chenxi_queue");
            messageConsumer = session.createConsumer(queue);

            //7.同步接收消息，直到接收到消息或者超时为止，都会阻塞程序  同步一般不常用
            TextMessage message = (TextMessage) messageConsumer.receive(5000);
            messageConsumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage)message;
                    try {
                        String text = textMessage.getText();
                        System.out.println("value:"+text);
                        textMessage.acknowledge();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
