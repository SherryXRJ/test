package edu.sherry.demo.common.rabbitmq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 官网地址
 * http://www.rabbitmq.com/documentation.html
 *
 * http://www.rabbitmq.com/tutorials/tutorial-three-spring-amqp.html
 */
@Configuration
public class RabbitMQConfiguration {

    @Value("${rabbitmq.host}")
    private String host;

    @Value("${rabbitmq.port}")
    private int port;

    @Value("${rabbitmq.username}")
    private String userName;

    @Value("${rabbitmq.password}")
    private String password;

    private final static String FANOUT_EXCHANGE_NAME = "sherry.fanout";

    private final static String DIRECT_EXCHANGE_NAME = "sherry.direct";

    private final static String TOPIC_EXCHANGE_NAME = "sherry.topic";

    private final static String RPC_EXCHANGE_NAME = "sherry.rpc";
    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory factory = new CachingConnectionFactory(host, port);
        factory.setUsername(userName);
        factory.setPassword(password);
        return factory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        return new RabbitTemplate(connectionFactory);
    }

    /**
     * Exchange - fanout    类似于广播
     */
    @Bean
    public FanoutExchange fanout(){
        return new FanoutExchange(FANOUT_EXCHANGE_NAME);
    }

    /**
     * Exchange - direct    类似于P2P
     */
    @Bean
    public DirectExchange direct(){
        return new DirectExchange(DIRECT_EXCHANGE_NAME);
    }

    /**
     * Exchange - topic     类似于订阅
     */
    @Bean
    public TopicExchange topic(){
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    /**
     * RabbitMQ - RPC
     */
    @Bean
    public DirectExchange rpcExchange(){
        return new DirectExchange(RPC_EXCHANGE_NAME);
    }
}
