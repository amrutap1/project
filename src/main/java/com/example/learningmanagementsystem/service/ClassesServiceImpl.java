package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.Enum.UserRole;
import com.example.learningmanagementsystem.exception.ClassExceptionHandler;
import com.example.learningmanagementsystem.model.Classes;
import com.example.learningmanagementsystem.model.Course;
import com.example.learningmanagementsystem.model.User;
import com.example.learningmanagementsystem.repository.IRepositoryUser;
import com.example.learningmanagementsystem.repository.IclassesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements IClassesService{

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
    public Classes save(Classes classes) throws ClassExceptionHandler {
//        Classes c=iclassesRepo.save(classes);
//        return c;
        User user=repositoryUser.findById(classes.getUser().getId()).orElse(null);
        Course course= iclassesRepo.findById(classes.getCourse().getCourseId()).orElse(null).getCourse();
        if (user.getRole().equals(UserRole.TEACHER)) {
            classes.getUser().setId(user.getId());
            classes.getUser().setUserName(user.getUserName());
            classes.getUser().setPassword(user.getPassword());
            classes.getUser().setRole(user.getRole());
            classes.getCourse().setCourseId(course.getCourseId());
            classes.getCourse().setCourseName(course.getCourseName());
            classes.getCourse().setUser(course.getUser());
            classes.getCourse().setStartDate(course.getStartDate());
            classes.getCourse().setEndDate(course.getEndDate());
            Classes c = iclassesRepo.save(classes);

            return c;
        }else {

            throw new ClassExceptionHandler();
        }
    }



    @Override
    public String deleteById(int classId) {
        if (iclassesRepo.findById(classId) != null) {
            iclassesRepo.deleteById(classId);
            return "Record Deleted";
        }

        else {

            return "Id not Found";
        }

    }


}
