package com.example.BusManagementProject.service;

import com.example.BusManagementProject.model.Route;
import com.example.BusManagementProject.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImplementation implements RouteService{

    @Autowired
    RouteRepository routeRepository;
    @Override
    public void addRoute(Route route) {
        routeRepository.save(route);
    }

    @Override
    public Optional<Route> getRoutById(Long id) {
        return routeRepository.findById(id);
    }

    @Override
    public List<Route> getAllRoute() {
        return routeRepository.findAll();
    }
}
