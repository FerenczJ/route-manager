package com.example.routemanager.web.controller;

import com.example.routemanager.service.CountryServiceImpl;
import com.example.routemanager.mapper.RouteMapper;
import com.example.routemanager.web.dto.RouteResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class RouteController {

    private CountryServiceImpl routeService;

    private RouteMapper routeMapper;

    @GetMapping("/routing/{origin}/{destination}")
    public ResponseEntity<RouteResponse> getRoute(@PathVariable String origin, @PathVariable String destination) {
        var route = routeService.getRoute(origin, destination);

        if (route == null || route.isEmpty()) return ResponseEntity.badRequest().build();

        var response = routeMapper.toRouteResponse(route);

        return ResponseEntity.ok(response);
    }
}
