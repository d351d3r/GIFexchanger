package com.example.demo.controller;

import com.example.demo.service.PageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.TreeMap;

@Controller
public class MainController {

    @Autowired
    PageClient pageClient;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("page", pageClient.getLatestPage().getRates());
        model.addAttribute("title", "Курсы Валют - тестовое задание");
        return "main";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Model model) {
        Map<String, Double> filteredRates = new TreeMap<>();
        if (filter != null && !filter.isEmpty()) {
            for (Map.Entry<String, Double> value : pageClient.getLatestPage().getRates().entrySet()) {
                if (value.getKey().contains(filter)) {
                    filteredRates.put(value.getKey(), value.getValue());
                }
            }
        } else {
            filteredRates = pageClient.getLatestPage().getRates();
        }
        model.addAttribute("page", filteredRates);
        return "main";
    }
}
