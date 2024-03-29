package com.example.BusManagementProject.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalTime;

@Data
public class AddScheduleRequest {
  @NotNull private String startTime;

  @NotNull private String endTime;

  @NotNull private String busRegNumber;

  @NotNull private Long routeId;

}
