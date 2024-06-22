package com.example.consuming_rest_apis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ConsumingRestApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApisApplication.class, args);
	}

}
