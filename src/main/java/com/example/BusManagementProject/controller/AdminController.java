package com.example.BusManagementProject.controller;


import com.example.BusManagementProject.model.Bus;
import com.example.BusManagementProject.model.Route;
import com.example.BusManagementProject.payload.request.AddScheduleRequest;
import com.example.BusManagementProject.payload.response.GenericResponse;
import com.example.BusManagementProject.service.BusService;
import com.example.BusManagementProject.service.RouteService;
import com.example.BusManagementProject.service.ScheduleService;
import com.example.BusManagementProject.service.UserService;
import io.swagger.v3.oas.annotations.headers.Header;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  BusService busService;

  @Autowired
  RouteService routeService;

  @Autowired
  ScheduleService scheduleService;

  @Autowired
  UserService userService;

  @PostMapping("/add-bus")
  public ResponseEntity<GenericResponse> addBus(@Valid @RequestBody Bus bus,@Valid @RequestHeader String token) {
    if(userService.isLoggedIn(token)) {
      if(userService.isAdmin(token)) {
        busService.addBus(bus);
        return ResponseEntity.ok(new GenericResponse("Bus added successfully"));
      }else{
        throw new RuntimeException("Only Admin can add bus");
      }
    }
    else {
      throw new RuntimeException("Invalid credentials");
    }
  }

  @PostMapping("/edit-bus")
  public ResponseEntity<GenericResponse> editBus(@Valid @RequestBody Bus bus, @Valid @RequestHeader String token) {
    if(userService.isLoggedIn(token)) {
      if (userService.isAdmin(token)) {
        busService.editBus(bus);
        return ResponseEntity.ok(new GenericResponse("Bus details updated successfully"));
      } else {
        throw new RuntimeException("Only Admin can edit bus details");
      }
    }
    else {
      throw new RuntimeException("Invalid credentials");
    }
  }

  @PostMapping("/delete-bus/{regNumber}")
  public ResponseEntity<GenericResponse> deleteBus(@PathVariable String regNumber, @Valid @RequestHeader String token) {
    if(userService.isLoggedIn(token)) {
      if (userService.isAdmin(token)){
        busService.deleteBus(regNumber);
        return ResponseEntity.ok(new GenericResponse("Bus deleted successfully"));
      }else{
        throw new RuntimeException("Only Admin can add bus");
      }
    }
    else {
      throw new RuntimeException("Invalid credentials");
    }
  }

  @PostMapping("/add-route")
  public ResponseEntity<GenericResponse> addRoute(@Valid @RequestBody Route route, @Valid @RequestHeader String token) {

    if(userService.isLoggedIn(token)) {
      if(userService.isAdmin(token)) {
        routeService.addRoute(route);
        return ResponseEntity.ok(new GenericResponse("Route added successfully"));
      }else{
        throw new RuntimeException("Only Admin can add bus");
      }
    }
    else {
      throw new RuntimeException("Invalid credentials");
    }
  }

  @PostMapping("/add-schedule")
  public ResponseEntity<GenericResponse> addSchedule(@RequestBody AddScheduleRequest addScheduleRequest, @RequestHeader String token) {
    boolean isLoggedIn = userService.isLoggedIn(token);
    if(isLoggedIn) {
      scheduleService.addSchedule(addScheduleRequest);
      return ResponseEntity.ok(new GenericResponse("Schedule added successfully"));
    }
    else {
      throw new RuntimeException("Invalid credentials");
    }
  }


}