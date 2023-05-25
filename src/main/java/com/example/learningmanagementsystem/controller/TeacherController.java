
package com.example.learningmanagementsystem.controller;


import com.example.learningmanagementsystem.dto.SubmCl;
import com.example.learningmanagementsystem.exception.SubExceptionHandler;
import com.example.learningmanagementsystem.model.*;
import com.example.learningmanagementsystem.repository.IclassesRepo;
import com.example.learningmanagementsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "http://localhost:3000")
public class TeacherController {

    @Autowired
    IClassesService classesService;
    @Autowired
    ISubmissionService submissionService;

    @Autowired
    ICourseService courseService;
    @Autowired
    IAssignService assignService;

    @Autowired
    IEnrollService iEnrollService;
    @Autowired
    IUserService userService;
    @Autowired
    IclassesRepo iclassesRepo;

    @GetMapping("/test")
    public String test(){
        return "in teacher controller";
    }


    @DeleteMapping("/deleteAssign")
    public ResponseEntity<String> deleteById(@RequestParam int assignId){
        assignService.deleteById(assignId);
        return  new ResponseEntity<String>("Record Deleted ", HttpStatus.OK);
    }
    @DeleteMapping("/deleteClass/{classId}")
    public ResponseEntity<String> deleteClass(@PathVariable("classId") int classId){

            classesService.deleteById(classId);
        return  new ResponseEntity<String>("Record Deleted ", HttpStatus.OK);

    }


    @GetMapping("/{courseId}/enrollments")
    public List<Enrollment> getEnrollmentsByCourseId(@PathVariable Long courseId) {
        return iEnrollService.getEnrollmentsByCourseId(courseId);
    }



//    @GetMapping("/teachers/{teacherId}/students")
//    public List<User> getEnrolledStudents(@PathVariable Long teacherId) {
//        return userService.getEnrolledStudents(teacherId);
//    }

}
