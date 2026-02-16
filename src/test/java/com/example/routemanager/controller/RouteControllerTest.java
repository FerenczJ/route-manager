package com.example.routemanager.controller;

import com.example.routemanager.mapper.RouteMapper;
import com.example.routemanager.service.CountryServiceImpl;
import com.example.routemanager.web.controller.RouteController;
import com.example.routemanager.web.dto.RouteResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RouteControllerTest {

    @Mock
    private CountryServiceImpl routeService;

    @Mock
    private RouteMapper routeMapper;

    @InjectMocks
    private RouteController routeController;

    @Test
    void getRoute_found() {
        var route = Arrays.asList("CZE", "AUT", "ITA");
        var responseDto = new RouteResponse(route);

        when(routeService.getRoute("CZE", "ITA")).thenReturn(route);
        when(routeMapper.toRouteResponse(route)).thenReturn(responseDto);

        var response = routeController.getRoute("CZE", "ITA");

        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(responseDto);
    }

    @Test
    void getRoute_notFound() {
        when(routeService.getRoute("CZE", "USA")).thenReturn(Collections.emptyList());

        var response = routeController.getRoute("CZE", "USA");

        assertThat(response.getStatusCode().value()).isEqualTo(400);
        assertThat(response.getBody()).isNull();
    }
}