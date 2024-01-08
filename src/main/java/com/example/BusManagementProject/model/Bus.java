package com.example.BusManagementProject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "bus"
)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name="reg_number", unique = true)
    private String regNumber;

    @NotNull
    @Column(name= "bus_type")
    private String busType;

}

