package com.zouftou.m2m.web;

import com.zouftou.m2m.domain.Sensor;
import com.zouftou.m2m.domain.SensorRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SensorController {

    private final SensorRepository sensorRepository;

    public SensorController(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @RequestMapping("/sensors")
    public Iterable<Sensor> getSensors() {
        return sensorRepository.findAll();
    }

    @RequestMapping(value = "/sensors/{name}")
    public Sensor getSensorByName(@PathVariable("name") String name) {
        Optional<Sensor> sensor = sensorRepository.findByName(name);
        if(sensor.isPresent()){
            return sensor.get();
        } else {
            throw new SensorNotFoundException("Sensor not found with name: " + name);
        }
    }
}
