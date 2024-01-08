package com.example.BusManagementProject.payload.request;

import com.example.BusManagementProject.model.Bus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddBusRequest {
    @NotNull private Bus bus;
    @NotNull private String token;
}
