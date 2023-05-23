package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.exception.AssignExceptionHandler;
import com.example.learningmanagementsystem.model.Assignment;
import com.example.learningmanagementsystem.model.Course;
import com.example.learningmanagementsystem.repository.IAssignRepo;
import com.example.learningmanagementsystem.repository.IRepositoryCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignService implements IAssignService {

    @Autowired
    IAssignRepo iAssignRepo;

    @Autowired
    IRepositoryCourse repositoryCourse;
    @Override
    public List<Assignment> getAllAssign() {
        List<Assignment> assignments=iAssignRepo.findAll();
        return assignments;
    }
    @Override
    public Assignment save(Assignment assignment) throws AssignExceptionHandler {
        Assignment c=iAssignRepo.save(assignment);
        return c;
//        Course course=repositoryCourse.findById(assignment.getCourse().getCourseId()).orElse(null);
//        if (assignment.getCourse().equals(course.getCourseId())) {
//           assignment.getCourse().setCourseId(course.getCourseId());
//            assignment.getCourse().setCourseName(course.getCourseName());
//            assignment.getCourse().setUser(course.getUser());
//            assignment.getCourse().setStartDate(course.getStartDate());
//            assignment.getCourse().setEndDate(course.getEndDate());
//            Assignment c = iAssignRepo.save(assignment);
//            return c;
//        }else {
//
//            throw new AssignExceptionHandler();
//        }
    }

    @Override
    public Assignment findById(int assignId){

        return iAssignRepo.findById(assignId).orElse(null);
    }

    @Override
    public void deleteById(int assignId) {

        iAssignRepo.deleteById(assignId);
    }
}
