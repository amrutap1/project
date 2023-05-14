package com.example.learningmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "classes")
public class Classes {

    @Id
    private int classId;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    private Time startTime;
    private Time endTime;


}
