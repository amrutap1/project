package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    User save(User user);

    List<User> getAlLTecher();

    User findById(int studentId);

//    List<User> getEnrolledStudents(Long teacherId);

    String check(String userName, String password, String role);
}
