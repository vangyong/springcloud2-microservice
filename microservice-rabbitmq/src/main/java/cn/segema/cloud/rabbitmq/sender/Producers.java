package cn.segema.cloud.rabbitmq.sender;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.segema.cloud.rabbitmq.domain.Student;

@Service
public class Producers {

	@Autowired
	RabbitMessagingTemplate rabbitSendTemplate;

	public void send(Student student) {
		System.out.println("send start.....");
		//rabbitSendTemplate.convertAndSend("default.topic", "test2.send", student);
		rabbitSendTemplate.convertAndSend("myFanoutExhange", "",student);
	}

}
