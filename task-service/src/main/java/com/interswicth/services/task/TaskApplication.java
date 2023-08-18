package com.interswicth.services.task;

import com.interswicth.services.task.model.Task;
import com.interswicth.services.task.repository.TaskRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info =
	@Info(title = "Task API", version = "1.0", description = "Documentation Task API v1.0")
)
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
	
	@Bean
	TaskRepository repository() {
		TaskRepository repository = new TaskRepository();
		repository.add(new Task("Development", 1L));
		repository.add(new Task( "Operations", 1L));
		repository.add(new Task("Development", 4L));
		repository.add(new Task("Operations", 3L));
		return repository;
	}
	
}
