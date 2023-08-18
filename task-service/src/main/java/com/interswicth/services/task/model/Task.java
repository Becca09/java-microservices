package com.interswicth.services.task.model;

public class Task {

	private Long id;
	private String name;

	public Task(String name, long employeeId) {
		this.name = name;
		this.employeeId = employeeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	private long employeeId;


}
