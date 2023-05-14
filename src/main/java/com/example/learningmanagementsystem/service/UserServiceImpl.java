package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.User;
import com.example.learningmanagementsystem.repository.IRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IRepositoryUser iRepositoryUser;


    @Override
    public List<User> getAll() {
        List<User> users=iRepositoryUser.findAll();
        return users;
    }
    @Override
    public User save(User user){
        User c=iRepositoryUser.save(user);
        return c;
    }


}
