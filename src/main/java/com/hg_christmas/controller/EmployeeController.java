package com.hg_christmas.controller;


import com.hg_christmas.model.Assignment;
import com.hg_christmas.model.Employee;
import com.hg_christmas.repo.AssignmentRepository;
import com.hg_christmas.service.AssignmentService;
import com.hg_christmas.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;
    private final AssignmentService assignmentService;

    private final AssignmentRepository assignmentRepository;

    public EmployeeController(EmployeeService employeeService,
                              AssignmentService assignmentService, AssignmentRepository assignmentRepository) {
        this.employeeService = employeeService;
        this.assignmentService = assignmentService;
        this.assignmentRepository = assignmentRepository;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAll();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @PostMapping("/assign/{id}")
    public Assignment assign(@PathVariable String id) {
        return assignmentService.assign(id);
    }

    @GetMapping("/available-employees")
    public List<Employee> getAvailableEmployees() {

        List<Employee> employees = employeeService.getAll();

        // ✅ Only remove employees who already selected
        employees.removeIf(Employee::isHasSelected);

        return employees;
    }


}
