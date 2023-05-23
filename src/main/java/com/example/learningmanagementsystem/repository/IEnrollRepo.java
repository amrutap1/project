package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEnrollRepo extends JpaRepository<Enrollment,Integer> {

    @Query("SELECT e FROM Enrollment e JOIN e.course c WHERE c.courseId = :courseId")
    List<Enrollment> findByCourseId(Long courseId);
}
