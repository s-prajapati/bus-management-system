package com.example.BusManagementProject.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupRequest {
  @NotBlank
  private String username;

  @NotBlank
  @Email
  private String email;

  private String role;

  @NotBlank
  private String password;
}
