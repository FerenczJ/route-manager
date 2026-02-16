package com.example.routemanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RouteController {

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("application", "Route Manager");
        return response;
    }

    @GetMapping("/routes")
    public Map<String, Object> getRoutes() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Route Manager API");
        response.put("version", "1.0.0");
        return response;
    }
}
