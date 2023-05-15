package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.Classes;
import com.example.learningmanagementsystem.repository.IclassesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements IClassesService{

    @Autowired
    IclassesRepo iclassesRepo;

    @Override
    public List<Classes> getAllClass() {
        List<Classes> classes=iclassesRepo.findAll();
        return classes;
    }
    @Override
    public Classes save(Classes classes){
        Classes c=iclassesRepo.save(classes);
        return c;
    }


}
