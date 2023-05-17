package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    User save(User user);

    User findById(int studentId);
}
