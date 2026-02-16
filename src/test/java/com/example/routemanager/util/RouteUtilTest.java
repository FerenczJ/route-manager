package com.example.routemanager.util;

import com.example.routemanager.model.Country;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RouteUtilTest {

    private static Country country(String cca3, String... borders) {
        var c = new Country();
        c.setCca3(cca3);
        c.setBorders(Arrays.asList(borders));
        return c;
    }

    @Test
    void testPathExists() {
        var map = new HashMap<String, Country>();
        map.put("A", country("A", "B"));
        map.put("B", country("B", "C"));
        map.put("C", country("C"));

        var path = RouteUtil.breadthFirstSearch(map, "A", "C");
        assertEquals(List.of("A", "B", "C"), path);
    }

    @Test
    void testNoPath() {
        var map = new HashMap<String, Country>();
        map.put("A", country("A", "B"));
        map.put("B", country("B"));
        map.put("C", country("C"));

        var path = RouteUtil.breadthFirstSearch(map, "A", "C");
        assertTrue(path.isEmpty());
    }

    @Test
    void testOriginEqualsDestination() {
        var map = new HashMap<String, Country>();
        map.put("A", country("A", "B"));

        var path = RouteUtil.breadthFirstSearch(map, "A", "A");
        assertEquals(List.of("A"), path);
    }

    @Test
    void testOriginNotInMap() {
        var map = new HashMap<String, Country>();
        map.put("B", country("B"));

        var path = RouteUtil.breadthFirstSearch(map, "A", "B");
        assertTrue(path.isEmpty());
    }

    @Test
    void testDestinationNotInMap() {
        var map = new HashMap<String, Country>();
        map.put("A", country("A", "B"));

        var path = RouteUtil.breadthFirstSearch(map, "A", "C");
        assertTrue(path.isEmpty());
    }
}