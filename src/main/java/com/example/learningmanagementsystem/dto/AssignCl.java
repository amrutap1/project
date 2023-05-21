package com.example.learningmanagementsystem.dto;

import jakarta.persistence.Table;

import java.time.LocalDate;

@Table(name = "assigncl")
public class AssignCl {


    String assignName;

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    LocalDate dueDate;


    int courseId;



    public String getAssignName() {
        return assignName;
    }

    public void setAssignName(String assignName) {
        this.assignName = assignName;
    }



    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public AssignCl() {
    }

    public AssignCl( String assignName, LocalDate dueDate, int courseId) {

        this.assignName = assignName;
        this.dueDate = dueDate;
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "AssignCl{" +
                ", assignName='" + assignName + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
