package com.interswicth.services.task.repository;

import com.interswicth.services.task.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private List<Task> departments = new ArrayList<>();

    public Task add(Task department) {
        department.setId((long) (departments.size() + 1));
        departments.add(department);
        return department;
    }

    public Task findById(Long id) {
        return departments.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Task> findAll() {
        return departments;
    }

    public List<Task> findByEmployeeId(Long employeeId) {
        return departments.stream()
                .filter(a -> a.getEmployeeId() == employeeId)
                .toList();
    }

}
