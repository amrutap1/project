package com.example.learningmanagementsystem.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "courseId")
    private int courseId;

    @Column(name = "courseName")
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private User user;

    @Column(name = "startDate")
    private  LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

}
