package edu.sherry.demo.testcustomer.mqcustomer;

import edu.sherry.demo.common.entry.MessageEntry;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQDirectCustomer {

    //  支持EL表达式  @RabbitListener(queues = "#{autoDeleteQueue1.name}")

    /**
     * 队列1消费者
     * {@link DirectCustomerConfig#directQueue1()}
     */
    @RabbitListener(queues = DirectCustomerConfig.DIRECT_QUEUE_1)
    public void directQueue1Customer(MessageEntry messageEntry){
        System.out.println(messageEntry.toString());
    }

    /**
     * 队列2消费者
     * {@link DirectCustomerConfig#directQueue2()}
     */
    @RabbitListener(queues = DirectCustomerConfig.DIRECT_QUEUE_2)
    public void directQueue2Customer(MessageEntry messageEntry){
        System.out.println(messageEntry.toString());
    }

    //  ===================================================================
    /**
     * 队列和routeKey 定义和绑定
     *
     * <p>定义了2个direct queue
     * <p>定义了4个route key
     * <p>绑定queue 和 direct; 指定一个route key到queue1, 其他三个route key到queue2
     */
    @Configuration
    public static class DirectCustomerConfig {

        /**
         * direct queue 1
         */
        private final static String DIRECT_QUEUE_1 = "directQueue1";

        /**
         * direct queue2
         */
        private final static String DIRECT_QUEUE_2 = "directQueue2";

        /**
         * route key - Java
         */
        private final static String DIRECT_QUEUE_ROUTE_KEY_JAVA = "Java";

        /**
         * route key - C
         */
        private final static String DIRECT_QUEUE_ROUTE_KEY_C = "C";

        /**
         * route key - Python
         */
        private final static String DIRECT_QUEUE_ROUTE_KEY_PYTHON = "Python";

        /**
         * route key - Kotlin
         */
        private final static String DIRECT_QUEUE_ROUTE_KEY_KOTLIN = "Kotlin";

        /**
         * 队列1
         * directQueue1
         */
        @Bean
        public Queue directQueue1() {
            return new Queue(DIRECT_QUEUE_1);
        }

        /**
         * 队列2
         * directQueue2
         */
        @Bean
        public Queue directQueue2() {
            return new Queue(DIRECT_QUEUE_2);
        }

        /**
         * 绑定 directQueue1 - direct 使用route key java
         */
        @Bean
        public Binding bindingDirect1a(DirectExchange direct, Queue directQueue1) {
            return BindingBuilder.bind(directQueue1)
                    .to(direct)
                    .with(DIRECT_QUEUE_ROUTE_KEY_JAVA);
        }

        /**
         * 绑定 directQueue2 - direct 使用route key C
         */
        @Bean
        public Binding bindingDirect2a(DirectExchange direct, Queue directQueue2) {
            return BindingBuilder.bind(directQueue2)
                    .to(direct)
                    .with(DIRECT_QUEUE_ROUTE_KEY_C);
        }

        /**
         * 绑定 directQueue2 - direct 使用route key python
         */
        @Bean
        public Binding bindingDirect2b(DirectExchange direct, Queue directQueue2) {
            return BindingBuilder.bind(directQueue2)
                    .to(direct)
                    .with(DIRECT_QUEUE_ROUTE_KEY_PYTHON);
        }

        /**
         * 绑定 directQueue2 - direct 使用route key kotlin
         */
        @Bean
        public Binding bindingDirect2c(DirectExchange direct, Queue directQueue2) {
            return BindingBuilder.bind(directQueue2)
                    .to(direct)
                    .with(DIRECT_QUEUE_ROUTE_KEY_KOTLIN);
        }

    }
}
