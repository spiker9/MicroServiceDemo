package com.example.ms.msdemo.controller;

import com.example.ms.msdemo.domain.Greeting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MSController{
    
    private static final String template = "Hello, %s";

    private final AtomicLong count = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greatings(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(count.incrementAndGet(), String.format(template, name));
    }
}