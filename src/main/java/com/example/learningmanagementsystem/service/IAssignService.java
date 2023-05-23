package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.exception.AssignExceptionHandler;
import com.example.learningmanagementsystem.model.Assignment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAssignService {


    List<Assignment> getAllAssign();



    Assignment save(Assignment assignment) throws AssignExceptionHandler;

    Assignment findById(int assignId);


    void deleteById(int assignId);
}
