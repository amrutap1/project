package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@EnableJpaRepositories
public interface IRepositoryUser extends JpaRepository <User,Integer>{


    @Query(value =
            "select * from dbproject.user where role=TEACHER",nativeQuery = true)
    public List<User> getAllTeacher();


    @Query(value = "SELECT * FROM user WHERE role = 'STUDENT'", nativeQuery = true)
    List<User> getAllStudent();


//    User findByUserName(String userName);

//    @Query(value = "Select * from User u where u.userName = '' AND u.password = ''",nativeQuery = true)
//@Query(value = "Select * from User u where u.userName =?1 AND u.password =?2 ",nativeQuery = true)


      User findByUserNameAndPassword(String userName, String password);


}
