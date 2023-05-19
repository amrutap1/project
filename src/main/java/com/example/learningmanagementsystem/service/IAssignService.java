package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.Assignment;

import java.util.List;

public interface IAssignService {


    List<Assignment> getAllAssign();



    Assignment save(Assignment assignment);

    Assignment findById(int assignId);
}
