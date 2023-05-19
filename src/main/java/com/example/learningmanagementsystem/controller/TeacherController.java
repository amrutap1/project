package com.example.learningmanagementsystem.controller;


import com.example.learningmanagementsystem.model.*;
import com.example.learningmanagementsystem.service.IAssignService;
import com.example.learningmanagementsystem.service.ICourseService;
import com.example.learningmanagementsystem.service.ISubmissionService;
import com.example.learningmanagementsystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "http://localhost:3000")
public class TeacherController {


    @Autowired
    ISubmissionService submissionService;

    @Autowired
    ICourseService courseService;
    @Autowired
    IAssignService assignService;

    @Autowired
    IUserService userService;

    @GetMapping("/test")
    public String test(){
        return "in teacher controller";
    }

    @PostMapping("/addSub")
    public Submission addSub(@RequestBody SubmCl submCl){
        int studentId = submCl.getStudentId();
        int assignId = submCl.getAssignId();
        String grade=submCl.getGrade();
        String feedback=submCl.getFeedback();
        User u=userService.findById(studentId);
        Assignment a=assignService.findById(assignId);
        Submission submission=new Submission();
        submission.setStudentId(u);
        submission.setAssignId(a);
        submission.setFeedback(feedback);
        submission.setGrade(grade);
        return submissionService.save(submission);
    }

//    @PostMapping('/addCourse')
//    public Course addCourse(@RequestBody CourseCl courseCl){
//
//    }



}
