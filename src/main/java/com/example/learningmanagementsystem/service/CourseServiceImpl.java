package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.Course;
import com.example.learningmanagementsystem.repository.IRepositoryCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    IRepositoryCourse iRepositoryCourse;
    @Override
    public List<Course> getAll() {
        List<Course> courses=iRepositoryCourse.findAll();
        return courses;
    }
    @Override
    public Course save(Course course){
        Course c=iRepositoryCourse.save(course);
        return c;
    }
    @Override
    public Course findById(int courseId){
        Course c=iRepositoryCourse.getById(courseId);
        return c;
    }

    @Override
    public Course getACourseById(int studentId){

        return iRepositoryCourse.findById(studentId).orElse(null);
    }



}
