package com.redoxengine.exercise.appointments;

import com.redoxengine.exercise.appointments.api.services.InitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AppointmentsApplication {


	public static void main(String[] args) {
		SpringApplication.run(AppointmentsApplication.class, args);
	}
}
