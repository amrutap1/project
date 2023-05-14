package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubmissionRepo extends JpaRepository<Submission,Integer> {
}
