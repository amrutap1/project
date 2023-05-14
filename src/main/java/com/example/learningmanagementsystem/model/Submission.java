package com.example.learningmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "submission")
public class Submission {

    @Id
    private int subId;

    private String grade;

    private String feedback;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "assignId")
    private Assignment assignment;
}
