package com.example.routemanager.service;

import java.util.List;

public interface CountryService {
    List<String> getRoute(String origin, String destination);
}
