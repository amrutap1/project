package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssignRepo extends JpaRepository<Assignment,Integer> {

}
