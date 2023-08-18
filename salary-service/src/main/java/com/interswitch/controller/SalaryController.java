package com.interswitch.controller;


import com.interswitch.client.EmployeeClient;
import com.interswitch.model.Salary;
import com.interswitch.repository.SalaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalaryController.class);

    SalaryRepository repository;

    EmployeeClient employeeClient;

    public SalaryController(SalaryRepository repository, EmployeeClient employeeClient) {
        this.repository = repository;
        this.employeeClient = employeeClient;
    }

    @PostMapping("/")
    public Salary add(@RequestBody Salary department) {
        LOGGER.info("Salary add: {}", department);
        return repository.add(department);
    }

    @GetMapping("/{id}")
    public Salary findById(@PathVariable("id") Long id) {
        LOGGER.info("Salary find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/")
    public List<Salary> findAll() {
        LOGGER.info("Salary find");
        return repository.findAll();

    }

    @GetMapping("/salary/{employeeId}/with-employees")
    public Salary findByEmployeeId(@PathVariable("employeeId") Long employeeId) {
        LOGGER.info("Salary find: employeeId={}", employeeId);
        return repository.findByEmployeeId(employeeId);
    }

    @PostMapping("/add/{id}")
    public String addDepartment(@PathVariable("id") Long salaryId, @RequestBody Long departmentId){

        var response = employeeClient.findByDepartmentId(departmentId);
        if(response != null){
            return repository.addDepartment(salaryId, departmentId);
        }
        else {
            return "Department id not found";
        }
    }

}
