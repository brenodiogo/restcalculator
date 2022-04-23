package com.brenodiogo.service;

import com.brenodiogo.dto.Input;
import com.brenodiogo.dto.Result;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class CalculatorService {

    public static final String SUM_ROUTING_KEY = "sum";
    public static final String SUB_ROUTING_KEY = "sub";
    public static final String MUL_ROUTING_KEY = "mul";
    public static final String DIV_ROUTING_KEY = "div";
    private final RabbitTemplate template;
    private final DirectExchange directExchange;


    public Result calculateSum(BigDecimal a, BigDecimal b) {
        Input input = convertInput(a, b);
        return getResult(input, SUM_ROUTING_KEY);
    }

    public Result calculateSub(BigDecimal a, BigDecimal b) {
        Input input = convertInput(a, b);
        return getResult(input, SUB_ROUTING_KEY);
    }

    public Result calculateMul(BigDecimal a, BigDecimal b) {
        Input input = convertInput(a, b);
        return getResult(input, MUL_ROUTING_KEY);
    }

    public Result calculateDiv(BigDecimal a, BigDecimal b) {
        Input input = convertInput(a, b);
        return getResult(input, DIV_ROUTING_KEY);
    }

    private Result getResult(Input input, String routingKey) {
        return template.convertSendAndReceiveAsType(directExchange.getName(), routingKey, input, new ParameterizedTypeReference<Result>() {
        });
    }

    private Input convertInput(BigDecimal a, BigDecimal b) {
        return Input.builder().a(a).b(b).build();
    }
}
