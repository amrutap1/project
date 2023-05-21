package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.dto.UserLogin;
import com.example.learningmanagementsystem.repository.IRepositoryUser;
import com.example.learningmanagementsystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
    @Autowired
    IUserService userService;

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody UserLogin userLogin) {
        String userName = userLogin.getUserName();
        String password = userLogin.getPassword();
        String role = userLogin.getRole();
        String msg=userService.check(userName,password,role);
        return msg;
    }


}
