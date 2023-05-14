package com.example.learningmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Enrollment")
public class Enrollment {

    @Id
    private int enrollId;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;
}
