package com.example.BusManagementProject.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDetailsResponse {
  private Time startTime;

  private Time endTime;

  private String busRegistrationNumber;

  private String startDestination;

  private String endDestination;
}
