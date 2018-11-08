package edu.sherry.demo.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import redis.clients.jedis.ShardedJedis;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
public class CommonApplicationTests {

    @Resource(name = "shardedJedis")
    private ShardedJedis shardedJedis;

    @Test
	public void contextLoads() {
        System.out.println(shardedJedis.get("k1"));
    }

}
