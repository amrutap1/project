package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.Assignment;
import com.example.learningmanagementsystem.repository.IAssignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignService implements IAssignService {

    @Autowired
    IAssignRepo iAssignRepo;

    @Override
    public List<Assignment> getAllAssign() {
        List<Assignment> assignments=iAssignRepo.findAll();
        return assignments;
    }
    @Override
    public Assignment save(Assignment assignment){
        Assignment c=iAssignRepo.save(assignment);
        return c;
    }

    @Override
    public Assignment findById(int assignId){
        return iAssignRepo.findById(assignId).orElse(null);
    }
}
