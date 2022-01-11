package com.rajiv.spring.rabbitmq.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rajiv.spring.rabbitmq.demo.config.MessagingConfig;
import com.rajiv.spring.rabbitmq.demo.dto.OrderStatus;

@Component
public class User {

	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeMessageFromQueue(OrderStatus orderStatus) {
		System.out.println("Message received from queue " + orderStatus);
	}

}
