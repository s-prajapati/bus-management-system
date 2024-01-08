package com.example.BusManagementProject.service;

import com.example.BusManagementProject.model.Schedule;
import com.example.BusManagementProject.payload.request.AddScheduleRequest;
import com.example.BusManagementProject.payload.response.RouteDetailsResponse;

import java.util.List;

public interface ScheduleService {
    void addSchedule(AddScheduleRequest addScheduleRequest);

    List<Schedule> getAllSchedule();

    List<RouteDetailsResponse> getScheduleByRouteId(Long routeId);
}
