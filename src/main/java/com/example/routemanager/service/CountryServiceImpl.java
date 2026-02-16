package com.example.routemanager.service;

import com.example.routemanager.model.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.example.routemanager.util.RouteUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
@Slf4j
public class CountryServiceImpl implements CountryService {
    private final ObjectMapper objectMapper;
    private final Map<String, Country> countryMap = new HashMap<>();

    public CountryServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        for (var country : loadCountries()) {
            countryMap.put(country.getCca3(), country);
        }
    }

    /**
     * Calculates the land route from origin to destination country.
     *
     * @param origin      the origin country code
     * @param destination the destination country code
     * @return List of country codes representing the route, or null if no route found
     */
    @Override
    public List<String> getRoute(String origin, String destination) {
        return RouteUtil.breadthFirstSearch(countryMap, origin, destination);
    }

    private List<Country> loadCountries() {
        try (InputStream is = new ClassPathResource("countries.json").getInputStream()) {
            return objectMapper.readValue(is, new TypeReference<>() {});
        } catch (IOException e) {
            log.error("Failed to load countries.json", e);
            return Collections.emptyList();
        }
    }
}
