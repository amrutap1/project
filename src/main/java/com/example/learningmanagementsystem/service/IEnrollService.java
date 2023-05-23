package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.Enrollment;

import java.util.List;

public interface IEnrollService {
    List<Enrollment> getAllEnroll();


    Enrollment save(Enrollment enrollCl);


    List<Enrollment> getEnrollmentsByCourseId(Long courseId);
}
