package com.zouftou.example;

import com.zouftou.example.domain.Task;
import com.zouftou.example.domain.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMongodbApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringMongodbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringMongodbApplication.class, args);
	}

	@Bean
	public CommandLineRunner clr(TaskRepository taskRepository) {
		return args -> {
			taskRepository.deleteAll();

			Task task1 = new Task("task num 1");
			Task task2 = new Task("task num 2");

			taskRepository.save(task1);
			taskRepository.save(task2);

			taskRepository.findAll()
					.forEach(s -> log.info("Task: {}", s.getName()));

			taskRepository.findByName(task1.getName())
					.ifPresent(s -> log.info("Task by name: {}", s.getName()));
		};
	}

}
