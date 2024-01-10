package com.example.BusManagementProject.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@AllArgsConstructor
public class LoginRequest {
  @NotBlank private String username;

  @NotBlank private String password;

}
