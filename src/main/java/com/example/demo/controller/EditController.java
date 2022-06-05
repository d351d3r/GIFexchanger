package com.example.demo.controller;

import com.example.demo.model.Page;
import com.example.demo.service.Calculator;
import com.example.demo.service.GiphyClient;
import com.example.demo.service.PageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("{getKey}")
public class EditController {

    @Autowired
    PageClient pageClient;
    @Autowired
    GiphyClient giphyClient;
    @Autowired
    Calculator calculator;

    @GetMapping
    public String details(@PathVariable(value = "getKey") String getKey, @RequestParam(required = false, defaultValue = "") String userDate, Model model) {
        Map<String, Double> details = new TreeMap<>();
        Double todayCurrency = pageClient.getLatestPage().getRates().get(getKey);
        details.put(getKey, todayCurrency);
        if (userDate != null && !userDate.isEmpty()) {
            Page pages = pageClient.getHistoricalPage(userDate, getKey);
            Double oldCurrency = pages.getRates().get(getKey);
            Object gif = giphyClient.giphyPic(calculator.result(todayCurrency, oldCurrency))
                    .getData()
                    .getImages()
                    .getOriginal()
                    .get("url");

            model.addAttribute("oldCurrency", oldCurrency);
            model.addAttribute("dates", userDate);
            model.addAttribute("gif", gif);
        }
        model.addAttribute("details", details);
        model.addAttribute("title", "Курсы Валют - сравнение");
        return "details";
    }


}
