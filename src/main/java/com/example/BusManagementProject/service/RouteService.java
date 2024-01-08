package com.example.BusManagementProject.service;

import com.example.BusManagementProject.model.Route;
import com.example.BusManagementProject.payload.response.RouteDetailsResponse;

import java.util.List;
import java.util.Optional;

public interface RouteService {
    void addRoute(Route route);

    Optional<Route> getRoutById(Long id);

    List<Route> getAllRoute();
}
