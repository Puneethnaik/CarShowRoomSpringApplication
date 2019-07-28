package com.punter.CarShowRoom;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CarShowRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarShowRoomApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CarRepository carRepository) {
		return args -> {
			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
					"AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(carName -> {
						Car car = new Car();
						car.setName(carName);
						carRepository.save(car);
			});
			carRepository.findAll().forEach(System.out::println);
		};
	}

}
