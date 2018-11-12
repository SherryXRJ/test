package edu.sherry.demo.testproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.ShardedJedis;

@RestController
@RequestMapping("/testProducer")
public class ProducerController {

    @Autowired
    private ShardedJedis shardedJedis;

    @RequestMapping("/get")
    @ResponseBody
    public String get(){
        return shardedJedis.get("");
    }

}
