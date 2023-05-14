package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRepositoryUser extends JpaRepository <User,Integer>{

}
