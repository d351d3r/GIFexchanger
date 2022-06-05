package com.example.demo.service;


import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public String result(Double today, Double old) {
        return (today > old) ? "rich" : "broke";
    }

}
