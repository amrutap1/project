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
@Table(name = "assignmnet")
public class Assignment {

    @Id
    private  int assignId;

    private String assignName;

    private LocalDate dueDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId")
    private Course course;
}
