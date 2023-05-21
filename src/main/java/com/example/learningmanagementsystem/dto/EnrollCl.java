package com.example.learningmanagementsystem.dto;


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
    int studentId;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }



    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public EnrollCl() {
    }

    public EnrollCl(int courseId, int studentId) {
        this.courseId = courseId;

        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "EnrollCl{" +
                "courseId=" + courseId +
                ", studentId=" + studentId +
                '}';
    }
}
