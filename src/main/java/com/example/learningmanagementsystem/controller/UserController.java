package com.example.learningmanagementsystem.controller;


import com.example.learningmanagementsystem.model.*;
import com.example.learningmanagementsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @Autowired
    ICourseService iCourseService;

    @Autowired
    IEnrollService iEnrollService;
    @Autowired
    IAssignService iAssignService;
    @Autowired
    IClassesService iClassesService;
    @Autowired
    IMessageService iMessageServic;
    @Autowired
    ISubmissionService iSubmissionService;
    @GetMapping("/test")
    public String test(){

        return "in user controller";
    }

    @GetMapping("/getAllCourse")
    List<Course> getCourses() {
        List<Course> courses = iCourseService.getAll();
        return courses;
    }

    @PostMapping("/addCourse")
    Course addCourse(@RequestBody Course course){
        Course c=iCourseService.save(course);
        return c;
    }

    @GetMapping("/getAllUser")
    List<User> getUser(){
        List<User> users= iUserService.getAll();
        return users;
    }
    @PostMapping("/addUser")
    User addUser(@RequestBody User user){
        User c=iUserService.save(user);
        return c;
    }
    @GetMapping("/getById/{studentId}")
    public Course getById(@PathVariable int studentId) {

        return iCourseService.getACourseById(studentId);
    }

    @GetMapping("/getAllAssign")
    List<Assignment> getAllAssign(){
        List<Assignment> assignments= iAssignService.getAllAssign();
        return assignments;
    }
    @PostMapping("/addAssign")
     public Assignment AddAssign(@RequestBody AssignCl assignCl){
//        Assignment c=iAssignService.save(assignment);
        int assignId=assignCl.getAssignId();
        String assignName=assignCl.getAssignName();
        LocalDate dueDate=assignCl.getDueDate();
        int courseId=assignCl.getCourseId();
        Assignment assignment=new Assignment();
        assignment.setAssignId(assignId);
        assignment.setAssignName(assignName);
        assignment.setDueDate(dueDate);
        Course c=iCourseService.findById(courseId);
        assignment.setCourse(c);
        return iAssignService.save(assignment);
    }

    @GetMapping("/getAllClass")
    List<Classes> getAllClass(){
        List<Classes> classes= iClassesService.getAllClass();
        return classes;
    }
    @PostMapping("/addClass")
    Classes AddAssign(@RequestBody Classes classes){
        Classes c=iClassesService.save(classes);
        return c;
    }

    @GetMapping("/getAllEnroll")
    public List<Enrollment> getAllEnroll() {
        List<Enrollment> enrollments=iEnrollService.getAllEnroll();
        return enrollments;
    }

    @PostMapping("/addEnroll")
    public ResponseEntity<String> AddEnroll(@RequestBody EnrollCl enrollCl){
//Enrollment c=iEnrollService.save(enrollCl);
        try{
        int enrollId=enrollCl.getEnrollId();
        int courseId=enrollCl.getCourseId();
        int studentId=enrollCl.getEnrollId();
        Course c=iCourseService.findById(courseId);
        User u=iUserService.findById(studentId);
        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(c);
        enrollment.setUser(u);
        enrollment.setEnrollId(enrollId);
         iEnrollService.save(enrollment);

            return ResponseEntity.status(HttpStatus.CREATED).body("Data added successfully.");
    }
    catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error.");
    }
}


    @GetMapping("/getAllMsg")
    public List<Messages> getAllMsg() {
        List<Messages> messages=iMessageServic.getAllMsg();
        return messages;
    }
    @PostMapping("/addMsg")
    public Messages save(Messages messages){
        Messages c=iMessageServic.save(messages);
        return c;
    }
    @GetMapping("/getSub")
    public List<Submission> getAllSub() {
        List<Submission> submissions=iSubmissionService.getAllSub();
        return submissions;
    }
    @PostMapping("/addSub")
    public Submission save(Submission submission){
        Submission c=iSubmissionService.save(submission);
        return c;
    }
}
