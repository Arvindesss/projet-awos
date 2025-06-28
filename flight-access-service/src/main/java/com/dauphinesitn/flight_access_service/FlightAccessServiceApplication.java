package com.dauphinesitn.flight_access_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@OpenAPIDefinition
@EnableDiscoveryClient
@EnableFeignClients("com.dauphinesitn.flight_access_service.client")
public class FlightAccessServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightAccessServiceApplication.class, args);
	}

}
