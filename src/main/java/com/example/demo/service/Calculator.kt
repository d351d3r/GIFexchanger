package com.example.demo.service

import org.springframework.stereotype.Service

@Service
class Calculator {
    fun result(today: Double, old: Double): String {
        return if (today > old) "rich" else "broke"
    }
}