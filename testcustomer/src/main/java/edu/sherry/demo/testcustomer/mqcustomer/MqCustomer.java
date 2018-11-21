package edu.sherry.demo.testcustomer.mqcustomer;

import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

//@Component
public class MqCustomer {

    //  queue
    private final static String DESTINATION_TEST_QUEUE = "sherry.queue.test";

    //  topic
    private final static String DESTINATION_TEST_TOPIC = "sherry.topic.test";

    @JmsListener(destination = DESTINATION_TEST_QUEUE, containerFactory = "queueListenerContainerFactory")
    public void queue(Message message) throws JMSException {
        System.out.println("queue");
        System.out.println(((TextMessage)message).getText());
    }

    @JmsListener(destination = DESTINATION_TEST_QUEUE, containerFactory = "queueListenerContainerFactory")
    public void queue2(Message message) throws JMSException {
        System.out.println("queue2");
        System.out.println(((TextMessage)message).getText());
    }

    @JmsListener(destination = DESTINATION_TEST_TOPIC, containerFactory = "topicListenerContainerFactory")
    public void topic(Message message) throws JMSException {
        System.out.println("topic");
        System.out.println(((TextMessage)message).getText());
    }

    @JmsListener(destination = DESTINATION_TEST_TOPIC, containerFactory = "topicListenerContainerFactory")
    public void topic2(Message message) throws JMSException {
        System.out.println("topic2");
        System.out.println(((TextMessage)message).getText());
    }

}
