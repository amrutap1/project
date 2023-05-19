package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.Submission;
import com.example.learningmanagementsystem.repository.ISubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService implements ISubmissionService {

    @Autowired
    ISubmissionRepo iSubmissionRepo;

    @Override
    public List<Submission> getAllSub() {
        List<Submission> submissions=iSubmissionRepo.findAll();
        return submissions;
    }
    @Override
    public Submission save(Submission submission){
        Submission c=iSubmissionRepo.save(submission);
        return c;
    }

    @Override
    public Submission findById(int subId){

        return iSubmissionRepo.findById(subId).orElse(null);
    }
}
