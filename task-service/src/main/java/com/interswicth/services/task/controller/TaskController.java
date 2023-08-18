package com.interswicth.services.task.controller;

import com.interswicth.services.task.model.Task;
import com.interswicth.services.task.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

	TaskRepository repository;

	public TaskController(TaskRepository repository) {
		this.repository = repository;
	}

	@PostMapping("/")
	public Task add(@RequestBody Task task) {
		LOGGER.info("Task add: {}", task);
		return repository.add(task);
	}
	
	@GetMapping("/{id}")
	public Task findById(@PathVariable("id") Long id) {
		LOGGER.info("Task find: id={}", id);
		return repository.findById(id);
	}
	
	@GetMapping("/")
	public List<Task> findAll() {
		LOGGER.info("Task find");
		return repository.findAll();
	}
	
	@GetMapping("/task/{employeeId}")
	public List<Task> findByEmployeeId(@PathVariable("employeeId") Long employeeId) {
		LOGGER.info("Department find: organizationId={}", employeeId);
		return repository.findByEmployeeId(employeeId);
	}
}
