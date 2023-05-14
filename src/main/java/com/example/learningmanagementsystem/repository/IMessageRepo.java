package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepo extends JpaRepository<Messages,Integer> {
}
