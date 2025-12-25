package com.hg_christmas.repo;

import com.hg_christmas.model.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AssignmentRepository extends MongoRepository<Assignment, String> {

    Optional<Assignment> findBySelectedEmployeeId(String selectedEmployeeId);
    List<Assignment> findAll();

}
