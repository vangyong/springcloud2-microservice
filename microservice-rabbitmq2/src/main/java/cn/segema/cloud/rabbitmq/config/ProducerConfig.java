package cn.segema.cloud.rabbitmq.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.segema.cloud.rabbitmq.util.RabbitUtil;
@Configuration
public class ProducerConfig {
	/*@Bean
    public RabbitMessagingTemplate msgMessageTemplate(ConnectionFactory connectionFactory) {
		
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        //参数列表分别是：1.交换器名称(default.topic 为默认值),2.是否长期有效,3.如果服务器在不再使用时自动删除交换器
        TopicExchange exchange = new TopicExchange("default.topic", true, false);
        rabbitAdmin.declareExchange(exchange);
        //1.队列名称,2.声明一个持久队列,3.声明一个独立队列,4.如果服务器在不再使用时自动删除队列
        Queue queue = new Queue("test.demo.send", true, false, false);
        rabbitAdmin.declareQueue(queue);
        //1.queue:绑定的队列,2.exchange:绑定到那个交换器,3.test2.send:绑定的路由名称
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with("test2.send"));
        
        return RabbitUtil.simpleMessageTemplate(connectionFactory);
    }*/
}
