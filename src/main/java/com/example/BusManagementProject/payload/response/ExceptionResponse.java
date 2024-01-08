package com.example.BusManagementProject.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ExceptionResponse {

  private final String message;

  @JsonIgnore private Date timestamp;
}
