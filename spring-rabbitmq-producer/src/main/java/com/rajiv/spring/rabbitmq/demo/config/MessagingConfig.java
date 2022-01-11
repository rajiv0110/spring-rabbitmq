package com.rajiv.spring.rabbitmq.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

	public static final String QUEUE = "java_queue";
	public static final String EXCHANGE = "java_exchange";
	public static final String ROUTING_KEY = "java_routingkey";

	@Bean
	public Queue queue() {
		return new Queue(QUEUE);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}

	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}

}
