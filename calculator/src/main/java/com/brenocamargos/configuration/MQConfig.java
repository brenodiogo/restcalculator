package com.brenocamargos.configuration;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    public static final String SUM_QUEUE = "sum.queue";
    public static final String SUB_QUEUE = "sub.queue";
    public static final String MUL_QUEUE = "mul.queue";
    public static final String DIV_QUEUE = "div.queue";
    public static final String CALCULATOR_EXCHANGE = "calculator.exchange";
    public static final String SUM = "sum";
    public static final String SUB = "sub";
    public static final String MUL = "mul";
    public static final String DIV = "div";

    @Bean
    public Queue sumQueue() {
        return new Queue(SUM_QUEUE);
    }

    @Bean
    public Queue subQueue() {
        return new Queue(SUB_QUEUE);
    }

    @Bean
    public Queue mulQueue() {
        return new Queue(MUL_QUEUE);
    }

    @Bean
    public Queue divQueue() {
        return new Queue(DIV_QUEUE);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(CALCULATOR_EXCHANGE);
    }

    @Bean
    public Binding sumBinding(Queue sumQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(sumQueue).to(directExchange).with(SUM);
    }

    @Bean
    public Binding subBinding(Queue subQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(subQueue).to(directExchange).with(SUB);
    }

    @Bean
    public Binding mulBinding(Queue mulQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(mulQueue).to(directExchange).with(MUL);
    }

    @Bean
    public Binding divBinding(Queue divQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(divQueue).to(directExchange).with(DIV);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
