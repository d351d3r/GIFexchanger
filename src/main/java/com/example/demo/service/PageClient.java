package com.example.demo.service;

import com.example.demo.model.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "PageClient",
        url = "${page.ribbon.listOfServers}")
public interface PageClient {

    @GetMapping(
            value = "/latest.json?app_id=" + "${api.valueId}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    Page getLatestPage();


    @GetMapping(
            value = "/historical/" + "{userDate}" + ".json?app_id=" + "${api.valueId}" + "&symbols=" + "{value}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    Page getHistoricalPage(@PathVariable String userDate, @PathVariable String value);
}

