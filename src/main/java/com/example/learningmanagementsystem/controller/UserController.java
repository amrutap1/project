package com.example.learningmanagementsystem.controller;


import com.example.learningmanagementsystem.model.Course;
import com.example.learningmanagementsystem.model.User;
import com.example.learningmanagementsystem.service.ICourseService;
import com.example.learningmanagementsystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @Autowired
    ICourseService iCourseService;


    @GetMapping("/getAllCourse")
    List<Course> getCourses() {
        List<Course> courses = iCourseService.getAll();
        return courses;
    }



    @GetMapping("/test")
    public String test(){

        return "in user controller";
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


}
