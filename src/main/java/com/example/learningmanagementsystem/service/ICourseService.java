package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.Course;

import java.util.List;

public interface ICourseService {
    List<Course> getAll();

    Course save(Course course);
}
