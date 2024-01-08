package com.example.BusManagementProject.controller;


import com.example.BusManagementProject.model.Bus;
import com.example.BusManagementProject.payload.request.AddScheduleRequest;
import com.example.BusManagementProject.payload.response.GenericResponse;
import com.example.BusManagementProject.service.BusService;
import com.example.BusManagementProject.service.ScheduleService;
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
  ScheduleService scheduleService;

  @PostMapping("/add-bus")
  public ResponseEntity<GenericResponse> addBus(@Valid @RequestBody Bus bus) {
    busService.addBus(bus);
    return ResponseEntity.ok(new GenericResponse("Bus added successfully"));
  }

  @PostMapping("/edit-bus")
  public ResponseEntity<GenericResponse> editBus(@Valid @RequestBody Bus bus) {
    busService.editBus(bus);
    return ResponseEntity.ok(new GenericResponse("Bus edited successfully"));
  }

  @PostMapping("/delete-bus/{regNumber}")
  public ResponseEntity<GenericResponse> deleteBus(@PathVariable String regNumber) {
    busService.deleteBus(regNumber);
    return ResponseEntity.ok(new GenericResponse("Bus deleted successfully"));
  }

  @PostMapping("/add-schedule")
  public ResponseEntity<GenericResponse> addSchedule(
      @RequestBody AddScheduleRequest addScheduleRequest) {
    scheduleService.addSchedule(addScheduleRequest);
    return ResponseEntity.ok(new GenericResponse("Bus deleted successfully"));
  }
}
