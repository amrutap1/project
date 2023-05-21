package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IRepositoryUser extends JpaRepository <User,Integer>{


    @Query(value =
            "select * from dbproject.user where role=TEACHER",nativeQuery = true)
    public List<User> getAllTeacher();

    User findByUserName(String userName);

    User findByUserNameAndPassword(String userName, String password);


}
