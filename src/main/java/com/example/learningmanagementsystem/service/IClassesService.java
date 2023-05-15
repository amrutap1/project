package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.Classes;

import java.util.List;

public interface IClassesService {
    List<Classes> getAllClass();

    Classes save(Classes classes);
}
