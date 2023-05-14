package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IclassesRepo extends JpaRepository<Classes ,Integer> {
}
