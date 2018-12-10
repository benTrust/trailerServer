package com.reactSpring.trailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.reactSpring.trailer.proxy")
class TrailerApplication {

	public static void main(final String[] args) {
		SpringApplication.run(TrailerApplication.class, args);
	}
}
