package edu.sherry.demo.testcustomer.mqcustomer;

import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class MqCustomer {


    @JmsListener(destination = "queue")
    public void queue(Message message) throws JMSException {
        System.out.println(message.toString());
    }

//    @JmsListener(destination = "topic")
//    public void topic(){
//
//    }

}
