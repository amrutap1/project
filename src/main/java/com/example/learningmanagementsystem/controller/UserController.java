package com.example.learningmanagementsystem.controller;


import com.example.learningmanagementsystem.dto.AssignCl;
import com.example.learningmanagementsystem.dto.ClassCl;
import com.example.learningmanagementsystem.dto.EnrollCl;
import com.example.learningmanagementsystem.dto.MessageCl;
import com.example.learningmanagementsystem.exception.AssignExceptionHandler;
import com.example.learningmanagementsystem.exception.ClassExceptionHandler;
import com.example.learningmanagementsystem.exception.CourseExceptionHandler;
import com.example.learningmanagementsystem.exception.SubExceptionHandler;
import com.example.learningmanagementsystem.model.*;
import com.example.learningmanagementsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
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
    Course addCourse(@RequestBody Course course) throws CourseExceptionHandler {
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
     public Assignment AddAssign( @RequestBody  AssignCl assignCl) {
//        Assignment c=iAssignService.save(assignment);
        String assignName=assignCl.getAssignName();
        LocalDate dueDate=assignCl.getDueDate();
        int courseId=assignCl.getCourseId();
        Assignment assignment=new Assignment();
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
    Classes AddClass(@RequestBody ClassCl classCl) throws ClassExceptionHandler {
//        Classes c=iClassesService.save(classes);
//        return c;
        int courseId=classCl.getCourseId();
        int teacherId=classCl.getTeacherId();
        Time startTime=classCl.getStartTime();
        Time endTime=classCl.getEndTime();
        Course c=iCourseService.findById(courseId);
        User u=iUserService.findById(teacherId);
        Classes classes=new Classes();
        classes.setCourse(c);
        classes.setUser(u);
        classes.setStartTime(startTime);
        classes.setEndTime(endTime);
        return iClassesService.save(classes);
    }

    @GetMapping("/getAllEnroll")
    public List<Enrollment> getAllEnroll() {
        List<Enrollment> enrollments=iEnrollService.getAllEnroll();
        return enrollments;
    }

    @PostMapping("/addEnroll")
    public Enrollment AddEnroll(@RequestBody EnrollCl enrollCl) {
//        Enrollment c = iEnrollService.save(enrollment);
//        return c;
        int courseId = enrollCl.getCourseId();
        int studentId = enrollCl.getStudentId();
        Course c = iCourseService.findById(courseId);
        User u = iUserService.findById(studentId);
        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(c);
        enrollment.setUser(u);
        return iEnrollService.save(enrollment);
    }

    @PostMapping("/addMsg")
    public Messages AddMsg(@RequestBody MessageCl messageCl){
        int senderId=messageCl.getSenderId();
        int receiverId= messageCl.getReceiverId();
        String content=messageCl.getContent();
        Timestamp timestamp=messageCl.getTimestamp();
        User u=iUserService.findById(senderId);
        User u2=iUserService.findById(receiverId);
        Messages messages=new Messages();
        messages.setUser(u);
        messages.setReceiverId(u2);
        messages.setContent(content);
        messages.setTimestamp(timestamp);
        return iMessageServic.save(messages);
    }
    @GetMapping("/getAllMsg")
    public List<Messages> getAllMsg() {
        List<Messages> messages=iMessageServic.getAllMsg();
        return messages;
    }
    @GetMapping("/getSub")
    public List<Submission> getAllSub() {
        List<Submission> submissions=iSubmissionService.getAllSub();
        return submissions;
    }
    @PostMapping("/addSub")
    public Submission AddSub(Submission submission) throws SubExceptionHandler {
        Submission c=iSubmissionService.save(submission);
        return c;
    }
    @GetMapping("/gradeById")
    public ResponseEntity<List<Submission>> getStudentGrades(@PathVariable("studentId") Long studentId) {
        List<Submission> studentGrades = iSubmissionService.getGradesByStudentId(studentId);
        return ResponseEntity.ok(studentGrades);
    }
}
