package com.example.learningmanagementsystem.model;

import jakarta.persistence.Table;

import java.time.LocalDate;

@Table(name = "assigncl")
public class AssignCl {

    int assignId;

    String assignName;

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    LocalDate dueDate;


    int courseId;

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



    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public AssignCl() {
    }

    public AssignCl(int assignId, String assignName, LocalDate dueDate, int courseId) {
        this.assignId = assignId;
        this.assignName = assignName;
        this.dueDate = dueDate;
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "AssignCl{" +
                "assignId=" + assignId +
                ", assignName='" + assignName + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
