package edu.sherry.demo.common.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import java.util.Properties;


/**
 * 参考官网配置
 * http://activemq.apache.org/spring-support.html
 */
@Configuration
public class ActiveMQConfiguration {

    /**
     * ActiveMQ连接工厂
     */
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        return new ActiveMQConnectionFactory();
    }

    @Bean(destroyMethod = "stop")
    public PooledConnectionFactory pooledConnectionFactory(ActiveMQConnectionFactory activeMQConnectionFactory){
        return new PooledConnectionFactory(activeMQConnectionFactory);
    }

    @Bean public JmsTemplate jmsTemplate(PooledConnectionFactory pooledConnectionFactory){
        return new JmsTemplate(pooledConnectionFactory);
    }
}
