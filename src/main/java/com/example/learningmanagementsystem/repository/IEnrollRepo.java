package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnrollRepo extends JpaRepository<Enrollment,Integer> {
}
