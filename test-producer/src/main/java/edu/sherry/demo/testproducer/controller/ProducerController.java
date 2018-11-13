package edu.sherry.demo.testproducer.controller;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.ShardedJedis;

import javax.annotation.Resource;
import javax.jms.Topic;

@RestController
@RequestMapping("/testProducer")
public class ProducerController {

    //  queue
    private final String DESTINATION_TEST_QUEUE = "sherry.queue.test";

    //  topic
    private final String DESTINATION_TEST_TOPIC = "sherry.topic.test";

    @Resource(name = "shardedJedis")
    private ShardedJedis shardedJedis;

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    @RequestMapping("/get")
    @ResponseBody
    public String get(){
        return shardedJedis.get("");
    }

    @GetMapping("/publishQueue")
    @ResponseBody
    public String publishQueue(){
        jmsTemplate.send(DESTINATION_TEST_QUEUE, session -> session.createTextMessage("Queue Test"));
        return "success";
    }

    @GetMapping("/publishTopic")
    public String publishTopic(){
        Topic topic = new ActiveMQTopic(DESTINATION_TEST_TOPIC);
        jmsTemplate.send(topic, session -> session.createTextMessage("Topic Test"));
        return "success";
    }
}
