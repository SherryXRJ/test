package pers.sherry.demo.testcustomer.mqcustomer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 参考
 * http://www.rabbitmq.com/tutorials/tutorial-five-spring-amqp.html
 */
@Component
public class RabbitMQTopicCustomer {

    @RabbitListener(queues = TopicCustomerConfig.TOPIC_QUEUE_1)
    public void topicCustomer1(String message){
        System.out.println(TopicCustomerConfig.TOPIC_QUEUE_1 + " receive :" + message);
    }

    @RabbitListener(queues = TopicCustomerConfig.TOPIC_QUEUE_2)
    public void topicCustomer2(String message){
        System.out.println(TopicCustomerConfig.TOPIC_QUEUE_2 + " receive :" + message);
    }

    //  ===========================================================================

    /**
     * Topic   queue,Exchange,RouteKey相关配置
     */
    @Configuration
    public static class TopicCustomerConfig{

        //  队列1名称
        private static final String TOPIC_QUEUE_1 = "topicQueue1";

        //  队列2名称
        private static final String TOPIC_QUEUE_2 = "topicQueue2";


        //  ROUTE KEY 规则  school.major.class


        //  route key 订阅 学校下所有
        private static final String TOPIC_ROUTE_KEY_1 = "cuit.#";

        //  route key 订阅 专业
        private static final String TOPIC_ROUTE_KEY_2 = "*.software.*";

        //  route key 订阅 班级
        private static final String TOPIC_ROUTE_KEY_3 = "*.*.class1";


        //  queue1
        @Bean
        public Queue topicQueue1(){
            return new Queue(TOPIC_QUEUE_1);
        }

        // queue2
        @Bean
        public Queue topicQueue2(){
            return new Queue(TOPIC_QUEUE_2);
        }

        @Bean
        public Binding bindingTopicQueue1a(TopicExchange topic, Queue topicQueue1){
            return BindingBuilder.bind(topicQueue1)
                    .to(topic)
                    .with(TOPIC_ROUTE_KEY_1);
        }

        @Bean
        public Binding bindingTopicQueue2a(TopicExchange topic, Queue topicQueue2){
            return BindingBuilder.bind(topicQueue2)
                    .to(topic)
                    .with(TOPIC_ROUTE_KEY_2);
        }

        @Bean
        public Binding bindingTopicQueue2b(TopicExchange topic, Queue topicQueue2){
            return BindingBuilder.bind(topicQueue2)
                    .to(topic)
                    .with(TOPIC_ROUTE_KEY_3);
        }
    }
}
