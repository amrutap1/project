package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.exception.SubExceptionHandler;
import com.example.learningmanagementsystem.model.Classes;
import com.example.learningmanagementsystem.model.Submission;

import java.util.List;

public interface ISubmissionService {
    List<Submission> getAllSub();
    Submission save(Submission submission) throws SubExceptionHandler;

    Submission findById(int subId);

    List<Submission> getGradesByStudentId(Long studentId);
}
