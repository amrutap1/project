package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    User save(User user);

    List<User> getAlLTecher();

    List<User> getAllStudent();

    User findById(int studentId);

//    List<User> getEnrolledStudents(Long teacherId);

//  s

    //    @Override
    //
    //    public List<User> getEnrolledStudents(Long teacherId) {
    //        return iRepositoryUser.findByTeacherId(teacherId);
    //    }
        //    public String check(String userName, String password, String role){
    //        User user = iRepositoryUser.findByUserNameAndPassword(userName, password);
    //        if(user != null && user.getRole().equals(role)){
    //            return "success";
    //        }
    //        return "failure";
    //



    User findByUserNameAndPassword(String userName, String password);

    //    @Override
    //
    //    public List<User> getEnrolledStudents(Long teacherId) {
    //        return iRepositoryUser.findByTeacherId(teacherId);
    //    }
    String check(String userName, String password, String role);
}
