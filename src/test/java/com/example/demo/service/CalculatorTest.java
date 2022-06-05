package com.example.demo.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CalculatorTest {

    @Autowired
    private Calculator calculator;

    @Test
    void Calc() {
        double a, b;
        a = 10.1;
        b = 5.2;
        Assert.assertEquals("rich", calculator.result(a, b));
        Assert.assertEquals("broke", calculator.result(b, a));
    }
}