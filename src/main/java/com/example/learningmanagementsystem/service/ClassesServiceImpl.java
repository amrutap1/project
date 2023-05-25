package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.Enum.UserRole;
import com.example.learningmanagementsystem.dto.ClassCl;
import com.example.learningmanagementsystem.exception.ClassExceptionHandler;
import com.example.learningmanagementsystem.model.Classes;
import com.example.learningmanagementsystem.model.Course;
import com.example.learningmanagementsystem.model.User;
import com.example.learningmanagementsystem.repository.IRepositoryCourse;
import com.example.learningmanagementsystem.repository.IRepositoryUser;
import com.example.learningmanagementsystem.repository.IclassesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements IClassesService{

    @Autowired
    IRepositoryCourse iRepositoryCourse;
    @Autowired
    IclassesRepo iclassesRepo;

    @Autowired
    IRepositoryUser repositoryUser;
    @Override
    public List<Classes> getAllClass() {
        List<Classes> classes=iclassesRepo.findAll();
        return classes;
    }


    @Override
    public Classes save(ClassCl classCl) throws ClassExceptionHandler {
//        Classes classes1=iclassesRepo.save(classes);
//        return classes1;
        User user=repositoryUser.findById(classCl.getTeacherId()).orElse(null);
        Course course=iRepositoryCourse.findById(classCl.getCourseId()).orElse(null);
        if (user.getRole().equals(UserRole.TEACHER)) {
            Classes c=new Classes();
            c.setUser(user);
            c.setCourse(course);
            c.setEndTime(classCl.getEndTime());
            c.setStartTime(classCl.getStartTime());
           return   iclassesRepo.save(c);

        }else {

            throw new ClassExceptionHandler();
        }
   }
    @Override
    public void deleteById(int classId) {

        iclassesRepo.deleteById(classId);
    }


}
