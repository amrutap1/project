package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.Enum.UserRole;
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
    public  List<User> getAllStudent(){
        return iRepositoryUser.getAllStudent();
    }

    @Override
    public User findById(int studentId){

        return iRepositoryUser.findById(studentId).orElse(null);
    }
    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        return iRepositoryUser.findByUserNameAndPassword(userName, password);
    }

    @Override
    public String check(String userName, String password, String role) {
    User user = iRepositoryUser.findByUserNameAndPassword(userName, password);
        System.out.println(user);
    if (user != null && user.getRole().equals(UserRole.valueOf(role)) ){
//      if(iRepositoryUser.equals("amruta") && iRepositoryUser.equals("Pass@123") && iRepositoryUser.equals("STUDENT")){
        return "success";
    }
    return "failure";
}




//
//@Override
//    public  User findByUserNameAndPassword(String userName, String password){
//        return iRepositoryUser.findByUserNameAndPassword(userName, password);
//    }
}
