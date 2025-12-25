package com.hg_christmas.service;

import com.hg_christmas.model.Assignment;
import com.hg_christmas.model.Employee;
import com.hg_christmas.repo.AssignmentRepository;
import com.hg_christmas.repo.EmployeeRepository;
import com.hg_christmas.template.SecretSantaEmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AssignmentService {

    @Autowired
    private  EmployeeRepository employeeRepo;
    @Autowired
    private  AssignmentRepository assignmentRepo;
    @Autowired
    private  EmailService emailService;
    @Autowired
    private SecretSantaEmailTemplate emailTemplate;


    public Assignment assign(String employeeId) {

        Employee selected = employeeRepo.findById(employeeId).orElseThrow();

        // 1️⃣ One-time submit rule
        if (selected.isHasSelected()) {
            throw new IllegalStateException("Selection already completed");
        }

        // 2️⃣ Get all employees
        List<Employee> employees = employeeRepo.findAll();

        // 3️⃣ Remove self
        employees.removeIf(e -> e.getId().equals(employeeId));

        // 4️⃣ Remove employees who already RECEIVED
        List<String> alreadyAssignedReceiverIds = assignmentRepo.findAll()
                .stream()
                .map(Assignment::getAssignedEmployeeId)
                .toList();

        employees.removeIf(e -> alreadyAssignedReceiverIds.contains(e.getId()));

        // 5️⃣ Safety check
        if (employees.isEmpty()) {
            throw new IllegalStateException("No employees available for assignment");
        }

        // 6️⃣ Pick random receiver
        Employee assigned = employees.get(new Random().nextInt(employees.size()));

        // 7️⃣ Save assignment
        Assignment assignment = new Assignment();
        assignment.setSelectedEmployeeId(selected.getId());
        assignment.setSelectedEmployeeName(selected.getName());
        assignment.setAssignedEmployeeId(assigned.getId());
        assignment.setAssignedEmployeeName(assigned.getName());

        selected.setHasSelected(true);
        employeeRepo.save(selected);
        assignmentRepo.save(assignment);

        String mailBody = emailTemplate.buildAssignmentMail(
                selected.getName(),
                assigned.getName()
        );

        emailService.sendEmail(
                selected.getEmail(),
                "🎁 Your Secret Santa Assignment Is Here!",
                mailBody
        );

        return assignment;
    }




}
