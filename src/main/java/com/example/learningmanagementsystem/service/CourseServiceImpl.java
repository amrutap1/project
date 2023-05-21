package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.Enum.UserRole;
import com.example.learningmanagementsystem.exception.CourseExceptionHandler;
import com.example.learningmanagementsystem.model.Course;
import com.example.learningmanagementsystem.model.User;
import com.example.learningmanagementsystem.repository.IRepositoryCourse;
import com.example.learningmanagementsystem.repository.IRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    IRepositoryCourse iRepositoryCourse;

    @Autowired
    IRepositoryUser repositoryUser;
    @Override
    public List<Course> getAll() {
        List<Course> courses=iRepositoryCourse.findAll();
        return courses;
    }
    @Override
    public Course save(Course course) throws CourseExceptionHandler {
//        List<User> teacher=repositoryUser.getAllTeacher();
//        int flag=0;
//        for (User user:teacher){
//           if( user.getRole().equals(UserRole.TEACHER))
//        }   for checking teacher id from user table
        User user=repositoryUser.findById(course.getUser().getId()).orElse(null);
        if (user.getRole().equals(UserRole.TEACHER)) {
            course.getUser().setId(user.getId());
            course.getUser().setUserName(user.getUserName());
            course.getUser().setPassword(user.getPassword());
            course.getUser().setRole(user.getRole());
            Course c = iRepositoryCourse.save(course);
            return c;
        }else {

            throw new CourseExceptionHandler();
        }
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
