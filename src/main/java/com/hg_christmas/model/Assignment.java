package com.hg_christmas.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "assignments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {

    @Id
    private String id;

    private String selectedEmployeeId;
    private String selectedEmployeeName;

    private String assignedEmployeeId;
    private String assignedEmployeeName;

    private LocalDateTime createdAt = LocalDateTime.now();

}
