package com.hg_christmas.service;

import com.hg_christmas.model.Employee;
import com.hg_christmas.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee add(Employee employee) {

        repo.findByEmail(employee.getEmail())
                .ifPresent(e -> {
                    throw new IllegalStateException("Employee already exists");
                });


        return repo.save(employee);
    }

    public Employee getById(String id) {
        return repo.findById(id).orElseThrow();
    }

    public void markSelected(Employee employee) {
        employee.setHasSelected(true);
        repo.save(employee);
    }
}
