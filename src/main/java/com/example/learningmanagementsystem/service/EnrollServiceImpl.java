package com.example.learningmanagementsystem.service;


import com.example.learningmanagementsystem.model.Enrollment;
import com.example.learningmanagementsystem.repository.IEnrollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollServiceImpl implements IEnrollService  {

    @Autowired
    IEnrollRepo iEnrollRepo;

    @Override
    public List<Enrollment> getAllEnroll() {
        List<Enrollment> enrollments=iEnrollRepo.findAll();
        return enrollments;
    }
    @Override
    public Enrollment save(Enrollment enrollment){
        Enrollment c=iEnrollRepo.save(enrollment);
        return c;
    }

}
