package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryCourse extends JpaRepository<Course, Integer> {
}
