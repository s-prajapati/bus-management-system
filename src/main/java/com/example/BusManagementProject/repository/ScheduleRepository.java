package com.example.BusManagementProject.repository;

import com.example.BusManagementProject.model.Bus;
import com.example.BusManagementProject.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByBus(Bus bus);


    @Query(value = "CALL GetRouteDetails(:routeId)", nativeQuery = true)
    List<Object[]> getRouteDetails(@Param("routeId") Long routeId);
}
