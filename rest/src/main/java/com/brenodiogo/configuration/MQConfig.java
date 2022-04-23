package com.brenodiogo.configuration;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    public static final String CALCULATOR_EXCHANGE = "calculator.exchange";

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(CALCULATOR_EXCHANGE);
    }

    @Bean
    public MessageConverter jackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
