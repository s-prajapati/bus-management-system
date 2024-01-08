package com.example.BusManagementProject;

import com.example.BusManagementProject.controller.AuthController;
import com.example.BusManagementProject.model.Route;
import com.example.BusManagementProject.payload.request.SignupRequest;
import com.example.BusManagementProject.service.RouteService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@OpenAPIDefinition(info = @Info(title = "Bus Managment System - Sahil Prajapati"))
public class BusManagementProjectApplication implements CommandLineRunner {

	@Autowired
	AuthController authController;

	@Autowired
	RouteService routeService;

	public static void main(String[] args) {
		SpringApplication.run(BusManagementProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		authController.registerUser(
				new SignupRequest("admin", "admin@gmail.com", "admin", "password"));

		routeService.addRoute(new Route(1L, "Delhi", "Bangalore"));
		routeService.addRoute(new Route(2L, "Bangalore", "Delhi"));
		routeService.addRoute(new Route(3L, "Chennai", "Delhi"));
		routeService.addRoute(new Route(4L, "Delhi", "Chennai"));
	}
}
