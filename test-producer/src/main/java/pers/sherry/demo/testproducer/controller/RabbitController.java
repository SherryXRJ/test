package pers.sherry.demo.testproducer.controller;

import pers.sherry.demo.common.entry.MessageEntry;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitController {

    @Resource(name = "rabbitTemplate")
    private RabbitTemplate rabbitTemplate;

    @Resource(name = "direct")
    private DirectExchange direct;

    @Resource(name = "topic")
    private TopicExchange topic;

    /**
     * 向directExchange发送消息
     */
    @GetMapping("/directPublish/{routeKey}")
    @ResponseBody
    public String directPublish(@PathVariable String routeKey) {
        MessageEntry message = new MessageEntry(1, "direct message");
        Map<Object, Object> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", "aaaa");
        message.setMapMessage(map);

        message.setListMessage(Arrays.asList("a", "b", "c", "d"));
        rabbitTemplate.convertAndSend(direct.getName(), routeKey, message);
        return "success";
    }

    @GetMapping("topicPublish/{routeKey}/{message}")
    @ResponseBody
    public String topicPublish(@PathVariable(name = "routeKey") String routeKey,
                               @PathVariable(name = "message") String message){
        rabbitTemplate.convertAndSend(topic.getName(), routeKey, message);
        return "success";
    }
}
