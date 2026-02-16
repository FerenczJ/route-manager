package com.example.routemanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RouteController {

    @GetMapping("/health")
    public String health() {
        return "Route Manager is running with Spring Boot 4.0.2";
    }

}
