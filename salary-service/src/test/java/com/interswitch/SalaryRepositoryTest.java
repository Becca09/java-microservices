package com.interswitch;

import com.interswitch.model.Salary;
import com.interswitch.repository.SalaryRepository;
import org.junit.jupiter.api.*;
import org.springframework.util.Assert;
import com.interswitch.model.Department;
import com.interswitch.repository.DepartmentRepository;

import java.math.BigDecimal;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SalaryRepositoryTest {

    private static final SalaryRepository repository = new SalaryRepository();
    private static Salary salary;

    @BeforeEach
    public void start(){
        salary = new Salary(1L, BigDecimal.valueOf(500.00));
        repository.add(salary);
    }
    @Test
    @Order(1)
    void testAddSalary() {
            Salary salary = new Salary(2L, BigDecimal.valueOf(500.00));
        salary = repository.add(salary);
        Assert.notNull(salary, "Salary is added.");
        Assert.isTrue(repository.findAll().size() == 2);
    }

    @Test
    @Order(2)
    void testFindAll() {
        List<Salary> salaries = repository.findAll();
        Assert.isTrue(salaries.size() == 1);
        Assert.isTrue(salaries.get(0).getEmployeeId() == 1L);
    }

    @Test
    @Order(3)
    void testAddDepartment() {
        repository.addDepartment(1L, 1L);
        List <Salary> salaries = repository.findAll();
        Assert.isTrue(salaries.size() == 1);
        Assert.isTrue(salaries.get(0).getEmployeeId() == 1L);
        Assert.isTrue(salaries.get(0).getDepartmentId() == 1L);
    }

    @Test
    @Order(4)
    void testFindById() {
        Salary salary = repository.findById(1L);
        Assert.notNull(salary);
        Assert.isTrue(salary.getEmployeeId() == 1L);
    }

}
