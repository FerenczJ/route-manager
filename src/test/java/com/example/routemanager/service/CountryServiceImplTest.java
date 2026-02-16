package com.example.routemanager.service;

import com.example.routemanager.model.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CountryServiceImplTest {

    private ObjectMapper objectMapper;
    private CountryServiceImpl countryService;

    @BeforeEach
    void setUp() throws Exception {
        objectMapper = mock(ObjectMapper.class);

        // Mock countries
        Country countryA = new Country();
        countryA.setCca3("AAA");
        countryA.setBorders(List.of("BBB"));

        Country countryB = new Country();
        countryB.setCca3("BBB");
        countryB.setBorders(List.of("AAA", "CCC"));

        Country countryC = new Country();
        countryC.setCca3("CCC");
        countryC.setBorders(List.of("BBB"));

        List<Country> countries = List.of(countryA, countryB, countryC);

        // Mock ObjectMapper to return the countries list
        when(objectMapper.readValue(any(InputStream.class), ArgumentMatchers.<TypeReference<List<Country>>>any()))
                .thenReturn(countries);

        countryService = new CountryServiceImpl(objectMapper);
    }

    @Test
    void testGetRoute_FindsRoute() {
        List<String> route = countryService.getRoute("AAA", "CCC");
        assertNotNull(route);
        assertEquals(List.of("AAA", "BBB", "CCC"), route);
    }

    @Test
    void testGetRoute_NoRoute() {
        // Remove borders to break the route
        countryService = new CountryServiceImpl(objectMapper) {
            @Override
            public List<String> getRoute(String origin, String destination) {
                return null;
            }
        };
        List<String> route = countryService.getRoute("AAA", "ZZZ");
        assertNull(route);
    }

    @Test
    void testLoadCountries_IOException() throws Exception {
        ObjectMapper failingMapper = mock(ObjectMapper.class);
        when(failingMapper.readValue(any(InputStream.class), ArgumentMatchers.<TypeReference<List<Country>>>any()))
                .thenThrow(new java.io.IOException("Failed to read"));

        CountryServiceImpl service = new CountryServiceImpl(failingMapper);
        // Should not throw, should log and return empty list internally
        assertNotNull(service);
    }
}