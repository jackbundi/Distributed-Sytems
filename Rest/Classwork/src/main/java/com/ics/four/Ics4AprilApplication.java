package com.ics.four;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class Ics4AprilApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ics4AprilApplication.class, args);
	}

	@Bean
	public feign.Logger.Level feignLoggerLevel() {
		return feign.Logger.Level.FULL;
	}

	@Bean
	public feign.Logger feignLogger() {
		return new feign.slf4j.Slf4jLogger();
	}
}
