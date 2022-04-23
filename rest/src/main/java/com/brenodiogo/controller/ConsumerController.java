package com.brenodiogo.controller;

import com.brenodiogo.dto.Result;
import com.brenodiogo.service.CalculatorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
@AllArgsConstructor
public class ConsumerController {

    final CalculatorService calculatorService;

    @GetMapping("/sum")
    public Result sum(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b) {
        logOperation("sum", a, b);
        return calculatorService.calculateSum(a, b);
    }

    @GetMapping("/sub")
    public Result sub(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b) {
        logOperation("sub", a, b);
        return calculatorService.calculateSub(a, b);
    }

    @GetMapping("/mul")
    public Result mul(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b) {
        logOperation("mul", a, b);
        return calculatorService.calculateMul(a, b);
    }

    @GetMapping("/div")
    public ResponseEntity div(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b) {
        logOperation("div", a, b);
        if (b.intValue() == 0) return new ResponseEntity("Can't divide by 0", HttpStatus.BAD_REQUEST);
        return new ResponseEntity(calculatorService.calculateDiv(a, b), HttpStatus.OK);
    }

    private void logOperation(String operation, BigDecimal a, BigDecimal b) {
        log.info("Requesting " + operation + " of numbers " + a + " and " + b);
    }
}
