package com.punter.CarShowRoom;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class CoolCarController {
    private CarRepository carRepository;

    public CoolCarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/getCoolCars")
    @CrossOrigin("http://localhost:4200")
    public Collection<Car> getCoolCars() {
        return carRepository.findAll().stream().filter(this::isCoolCar).collect(Collectors.toList());
    }
    private Boolean isCoolCar(Car car) {
        /*
         *  This function returns a true value for a car that is cool and false for a car that isnt. The criteria is decided in this function.
         */
        return !car.getName().equals("AMC Gremlin") &&
                !car.getName().equals("Triumph Stag") &&
                !car.getName().equals("Ford Pinto") &&
                !car.getName().equals("Yugo GV");
    }

}
