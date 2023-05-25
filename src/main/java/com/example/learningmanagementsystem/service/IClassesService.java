package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.dto.ClassCl;
import com.example.learningmanagementsystem.exception.ClassExceptionHandler;
import com.example.learningmanagementsystem.model.Classes;

import java.util.List;

public interface IClassesService {
    List<Classes> getAllClass();

//    Classes save(Classes classes) throws ClassExceptionHandler;

//    Classes save(Classes classes) throws ClassExceptionHandler;

    Classes save(ClassCl classCl) throws ClassExceptionHandler;

    void deleteById(int classId);

}
