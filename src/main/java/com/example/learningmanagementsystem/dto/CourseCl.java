package com.example.learningmanagementsystem.dto;


import jakarta.persistence.Table;

import java.time.LocalDate;

@Table(name = "courseCl")
public class CourseCl {


    String CourseName;

    int teacherId;

    LocalDate startDate;
    LocalDate endDate;

    public CourseCl() {
    }

    public CourseCl(String courseName, int teacherId, LocalDate startDate, LocalDate endDate) {
        CourseName = courseName;
        this.teacherId = teacherId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
