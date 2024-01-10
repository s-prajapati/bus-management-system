package com.example.BusManagementProject.controller;

import com.example.BusManagementProject.model.Bus;
import com.example.BusManagementProject.model.Route;
import com.example.BusManagementProject.model.Schedule;
import com.example.BusManagementProject.payload.response.RouteDetailsResponse;
import com.example.BusManagementProject.service.BusService;
import com.example.BusManagementProject.service.RouteService;
import com.example.BusManagementProject.service.ScheduleService;
import com.example.BusManagementProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  BusService busService;

  @Autowired
  RouteService routeService;

  @Autowired
  UserService userService;

  @Autowired
  ScheduleService scheduleService;

  @GetMapping("/get-all-bus")
  public ResponseEntity<List<Bus>> getAllBus(@Valid @RequestHeader String token) {
    if(userService.isLoggedIn(token)) {
      return ResponseEntity.ok(busService.getAllBus());
    }
    else{
      throw new RuntimeException("Invalid credentials");
    }
  }

  @GetMapping("/get-all-routes")
  public ResponseEntity<List<Route>> getAllRoutes(@Valid @RequestHeader String token) {
    if(userService.isLoggedIn(token)) {
      return ResponseEntity.ok(routeService.getAllRoute());
    }
    else{
      throw new RuntimeException("Invalid credentials");
    }
  }

  @GetMapping("/get-all-schedule")
  public ResponseEntity<List<Schedule>> getAllSchedule(@Valid @RequestHeader String token) {
    if(userService.isLoggedIn(token)) {
      return ResponseEntity.ok(scheduleService.getAllSchedule());
    }
    else{
      throw new RuntimeException("Invalid credentials");
    }
  }

  @GetMapping("/get-schedule-by-route-id/{routeId}")
  public ResponseEntity<List<RouteDetailsResponse>> getScheduleByRouteId(@PathVariable Long routeId,@Valid @RequestHeader String token) {
    if(userService.isLoggedIn(token)) {
      return ResponseEntity.ok(scheduleService.getScheduleByRouteId(routeId));
    }
    else{
      throw new RuntimeException("Invalid credentials");
    }
  }
}
