package edu.sherry.demo.testproducer.rabbitmqRPC;

import edu.sherry.demo.common.entry.MessageEntry;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;


@Configuration
public class RpcConfiguration {

    private final static String RPC_QUEUE_NAME = "rpc.queue";

    private final static String RPC_ROUTE_KEY = "rpc";

    @RabbitListener(queues = RPC_QUEUE_NAME)
    public MessageEntry rpcCallback(int num) {
        MessageEntry response = new MessageEntry(num / 2, new Date().toString());
        response.setListMessage(Arrays.asList("tom", "jerry", "peter"));
        return response;
    }

    @Bean
    public Queue rpcQueue() {
        return new Queue(RPC_QUEUE_NAME);
    }

    @Bean
    public Binding rpcBinding(Queue rpcQueue, DirectExchange rpcExchange) {
        return BindingBuilder.bind(rpcQueue)
                .to(rpcExchange)
                .with(RPC_ROUTE_KEY);
    }
}
