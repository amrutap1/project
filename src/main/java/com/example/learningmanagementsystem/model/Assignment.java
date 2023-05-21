package com.example.learningmanagementsystem.model;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "assignmnet")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int assignId;

    private String assignName;

    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    public Assignment() {
    }

    public Assignment(int assignId, String assignName, LocalDate dueDate, Course course) {
        this.assignId = assignId;
        this.assignName = assignName;
        this.dueDate = dueDate;
        this.course = course;
    }

    public int getAssignId() {
        return assignId;
    }

    public void setAssignId(int assignId) {
        this.assignId = assignId;
    }

    public String getAssignName() {
        return assignName;
    }

    public void setAssignName(String assignName) {
        this.assignName = assignName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignId=" + assignId +
                ", assignName='" + assignName + '\'' +
                ", dueDate=" + dueDate +
                ", course=" + course +
                '}';
    }
}
