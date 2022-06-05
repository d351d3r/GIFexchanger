package com.example.demo.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "PageClient", url = "\${page.ribbon.listOfServers}")
interface PageClient {
    @get:GetMapping(value = ["/latest.json?app_id=" + "\${api.valueId}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    val latestPage: Page?

    @GetMapping(value = ["/historical/" + "{userDate}" + ".json?app_id=" + "\${api.valueId}" + "&symbols=" + "{value}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun getHistoricalPage(@PathVariable userDate: String?, @PathVariable value: String?): Page?
}