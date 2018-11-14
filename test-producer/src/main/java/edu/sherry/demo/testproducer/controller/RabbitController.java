package edu.sherry.demo.testproducer.controller;

import edu.sherry.demo.common.entry.MessageEntry;
import org.springframework.amqp.core.DirectExchange;
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
}
