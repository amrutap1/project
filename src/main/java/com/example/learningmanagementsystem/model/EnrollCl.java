package com.example.learningmanagementsystem.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data

@Table(name = "enrollCl")
public class EnrollCl {
    int courseId;
    int enrollId;
    int studentId;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(int enrollId) {
        this.enrollId = enrollId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public EnrollCl() {
    }

    public EnrollCl(int courseId, int enrollId, int studentId) {
        this.courseId = courseId;
        this.enrollId = enrollId;
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "EnrollCl{" +
                "courseId=" + courseId +
                ", enrollId=" + enrollId +
                ", studentId=" + studentId +
                '}';
    }
}
