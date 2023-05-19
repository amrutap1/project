package com.example.learningmanagementsystem.model;

import jakarta.persistence.Table;

@Table(name = "submcl")
public  class SubmCl {

    String grade;
    String feedback;
    int studentId;
    int assignId;

    public SubmCl() {
    }

    public SubmCl(String grade, String feedback, int studentId, int assignId) {
        this.grade = grade;
        this.feedback = feedback;
        this.studentId = studentId;
        this.assignId = assignId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAssignId() {
        return assignId;
    }

    public void setAssignId(int assignId) {
        this.assignId = assignId;
    }

    @Override
    public String toString() {
        return "SubmCl{" +
                "grade='" + grade + '\'' +
                ", feedback='" + feedback + '\'' +
                ", studentId=" + studentId +
                ", assignId=" + assignId +
                '}';
    }
}
