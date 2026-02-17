package com.example.routemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    private String cca3;            // name of the country in 3-letter code
    private List<String> borders;   // list of neighboring countries in 3-letter code
}
