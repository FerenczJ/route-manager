package com.example.routemanager.web.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RouteRequestTest {

    @Test
    void testNoArgsConstructorAndSettersGetters() {
        RouteRequest req = new RouteRequest();
        req.setOrigin("A");
        req.setDestination("B");

        assertEquals("A", req.getOrigin());
        assertEquals("B", req.getDestination());
    }
}