package com.brenocamargos.service;

import com.brenocamargos.configuration.MQConfig;
import com.brenocamargos.dto.Input;
import com.brenocamargos.dto.Result;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;

@Component
public class MQService {

    @RabbitListener(queues = MQConfig.SUM_QUEUE)
    public Result processSumQueue(Input input) {
        return Result.builder()
                .result(input.getA().add(input.getB()))
                .build();
    }

    @RabbitListener(queues = MQConfig.SUB_QUEUE)
    public Result processSubQueue(Input input) {
        return Result.builder()
                .result(input.getA().subtract(input.getB()))
                .build();
    }

    @RabbitListener(queues = MQConfig.MUL_QUEUE)
    public Result processMulQueue(Input input) {
        return Result.builder()
                .result(input.getA().multiply(input.getB()))
                .build();
    }

    @RabbitListener(queues = MQConfig.DIV_QUEUE)
    public Result processDivQueue(Input input) {
        if (input.getB().compareTo(BigDecimal.ZERO) == 0) return null;
        return Result.builder()
                .result(input.getA().divide(input.getB(), MathContext.DECIMAL128))
                .build();
    }
}