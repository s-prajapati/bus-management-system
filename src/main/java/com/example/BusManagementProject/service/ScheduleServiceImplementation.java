package com.example.BusManagementProject.service;

import com.example.BusManagementProject.model.Bus;
import com.example.BusManagementProject.model.Route;
import com.example.BusManagementProject.model.Schedule;
import com.example.BusManagementProject.payload.request.AddScheduleRequest;
import com.example.BusManagementProject.payload.response.RouteDetailsResponse;
import com.example.BusManagementProject.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImplementation implements ScheduleService{

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    BusService busService;

    @Autowired
    RouteService routeService;
    @Override
    public void addSchedule(AddScheduleRequest addScheduleRequest) {
        Optional<Bus> bus = busService.findByRegNumber(addScheduleRequest.getBusRegNumber());
        Optional<Route> route = routeService.getRoutById(addScheduleRequest.getRouteId());
        if(bus.isPresent() && route.isPresent()) {
            List<Schedule> scheduleList = scheduleRepository.findByBus(bus.get());
            if(isNewScheduleNonOverLapping(
                    addScheduleRequest.getStartTime(),
                    addScheduleRequest.getEndTime(),
                    scheduleList)) {
                Schedule newSchedule = new Schedule(
                        null,
                        addScheduleRequest.getStartTime(),
                        addScheduleRequest.getEndTime(),
                        bus.get(),
                        route.get()
                );
                scheduleRepository.save(newSchedule);
            }
            else {
                throw new RuntimeException("This bus is not available at this time");
            }
        }
        else if(route.isPresent()) {
            throw new RuntimeException("No Bus found with given registration number");
        }
        else if(bus.isPresent()){
            throw new RuntimeException("Route Not found");
        }
        else throw new RuntimeException("Route and Bus Not Found");

    }

    private boolean isNewScheduleNonOverLapping(
            LocalTime startTime, LocalTime endTime, List<Schedule> scheduleList
    ) {
        for(Schedule schedule: scheduleList) {
            boolean isOverLapping = !startTime.isAfter(schedule.getEndTime()) && !endTime.isBefore(schedule.getStartTime());
            if(isOverLapping) return false;
        }
        return true;
    }

    @Override
    public List<Schedule> getAllSchedule() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<RouteDetailsResponse> getScheduleByRouteId(Long routeId) {
        List<Object[]> schedules = scheduleRepository.getRouteDetails(routeId);
        List<RouteDetailsResponse> routeDetailsResponseList = new ArrayList<>();
        for(Object[] schedule: schedules){
            RouteDetailsResponse routeDetails = new RouteDetailsResponse();
            routeDetails.setStartTime((Time) schedule[0]);
            routeDetails.setEndTime((Time) schedule[1]);
            routeDetails.setBusRegistrationNumber((String) schedule[2]);
            routeDetails.setStartDestination((String) schedule[3]);
            routeDetails.setEndDestination((String) schedule[4]);

            routeDetailsResponseList.add(routeDetails);
        }

        return routeDetailsResponseList;
    }
}
