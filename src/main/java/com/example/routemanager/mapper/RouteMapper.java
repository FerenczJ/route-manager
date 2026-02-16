package com.example.routemanager.mapper;

import com.example.routemanager.web.dto.RouteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RouteMapper {

    default RouteResponse toRouteResponse(List<String> route) {
        return new RouteResponse(route);
    }
}
