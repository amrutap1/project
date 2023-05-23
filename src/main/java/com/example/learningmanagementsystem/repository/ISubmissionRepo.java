package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.Submission;
import com.example.learningmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISubmissionRepo extends JpaRepository<Submission,Integer> {
    List<Submission> findByStudentId(User student);
}
