package com.interswitch.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.interswitch.model.Employee;

@FeignClient(name = "employee-service")
public interface EmployeeClient {
	@GetMapping("/department/{id}")
	List<Employee> findByEmployeeId(@PathVariable("id") Long departmentId);
	@GetMapping("/department/{departmentId}")
	List<Employee> findByDepartmentId(@PathVariable("departmentId") Long departmentId);
	
}
