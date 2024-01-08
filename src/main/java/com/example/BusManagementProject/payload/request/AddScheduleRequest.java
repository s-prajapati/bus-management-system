package com.example.BusManagementProject.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalTime;

@Data
public class AddScheduleRequest {
  @NotNull private LocalTime startTime;

  @NotNull private LocalTime endTime;

  @NotNull private String busRegNumber;

  @NotNull private Long routeId;

  @NotNull private String token;
}
