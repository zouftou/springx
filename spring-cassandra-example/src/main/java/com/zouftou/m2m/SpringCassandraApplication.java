package com.zouftou.m2m;

import com.zouftou.m2m.domain.Sensor;
import com.zouftou.m2m.domain.SensorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class SpringCassandraApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringCassandraApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringCassandraApplication.class, args);
	}

	@Bean
	public CommandLineRunner clr(SensorRepository sensorRepository) {
		return args -> {
			sensorRepository.deleteAll();

			Sensor oilPrecision = new Sensor(UUID.randomUUID(), "oilPrecision");
			Sensor temperature = new Sensor(UUID.randomUUID(), "temperature");

			sensorRepository.save(oilPrecision);
			sensorRepository.save(temperature);

			sensorRepository.findAll()
					.forEach(s -> log.info("Sensor: {}", s.getName()));

			sensorRepository.findByName(oilPrecision.getName())
					.ifPresent(s -> log.info("Sensor by name: {}", s.getName()));
		};
	}
}
