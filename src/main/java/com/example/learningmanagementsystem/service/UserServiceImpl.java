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

    @Override
    public  List<User> getAlLTecher(){
        return iRepositoryUser.getAllTeacher();
    }

    @Override
    public User findById(int studentId){

        return iRepositoryUser.findById(studentId).orElse(null);
    }

//    @Override
//
//    public List<User> getEnrolledStudents(Long teacherId) {
//        return iRepositoryUser.findByTeacherId(teacherId);
//    }
    @Override
    public String check(String userName, String password, String role){
        User user = iRepositoryUser.findByUserNameAndPassword(userName, password);
        if(user != null && user.getRole().equals(role)){
            return "success";
        }
        return "failure";
    }
}
