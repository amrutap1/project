package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.exception.SubExceptionHandler;
import com.example.learningmanagementsystem.model.Classes;
import com.example.learningmanagementsystem.model.Submission;
import com.example.learningmanagementsystem.model.User;

import java.util.List;

public interface ISubmissionService {
    List<Submission> getAllSub();
    Submission save(Submission submission) throws SubExceptionHandler;

    List<Submission> getGradesByStudent(User student);

    Submission findById(int subId);


}
