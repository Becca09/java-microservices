package com.interswitch.repository;


import com.interswitch.model.Salary;

import java.util.ArrayList;
import java.util.List;

public class SalaryRepository {

    private List<Salary> departments = new ArrayList<>();

    public Salary add(Salary department) {
        department.setId((long) (departments.size() + 1));
        departments.add(department);
        return department;
    }

    public Salary findById(Long id) {
        return departments.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Salary> findAll() {
        return departments;
    }


    public Salary findByEmployeeId(Long employeeId) {
        for (Salary s : departments) {
            if (s.getEmployeeId() == employeeId) return s;
        }

        return null;
    }

    public String addDepartment(Long salaryId, Long departmentId){
        Salary salary = findById(salaryId);
        if(salary == null){
            throw new IllegalArgumentException("Salary id does not exist");
        }
        salary.setDepartmentId(departmentId);
        return "Department added successfully";
    }
}
