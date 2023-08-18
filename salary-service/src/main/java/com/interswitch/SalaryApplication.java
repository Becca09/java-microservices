package com.interswitch;

import com.interswitch.model.Salary;
import com.interswitch.repository.DepartmentRepository;
import com.interswitch.repository.SalaryRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import com.interswitch.model.Department;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info =
	@Info(title = "Salary API", version = "1.0", description = "Documentation Salary API v1.0")
)
public class SalaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalaryApplication.class, args);
	}
	@Bean
	DepartmentRepository repositoryy() {
		DepartmentRepository repository = new DepartmentRepository();
		repository.add(new Department(1L, "Development"));
		repository.add(new Department(1L, "Operations"));
		repository.add(new Department(2L, "Development"));
		repository.add(new Department(2L, "Operations"));
		return repository;
	}
	@Bean
	SalaryRepository repository() {
		SalaryRepository repository = new SalaryRepository();
		repository.add(new Salary(2L, new BigDecimal(2000)));
		repository.add(new Salary(3L, new BigDecimal(2000)));
		repository.add(new Salary(1L, new BigDecimal(2000)));
		repository.add(new Salary(4L, new BigDecimal(2000)));
		return repository;
	}
	
}
