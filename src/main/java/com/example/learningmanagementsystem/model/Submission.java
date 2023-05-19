package com.example.learningmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "submission")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subId;

    private String grade;

    private String feedback;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private User studentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assignId")
    private Assignment assignId;
    public User getStudentId() {
        return studentId;
    }

    public void setStudentId(User studentId) {
        this.studentId = studentId;
    }

    public Assignment getAssignId() {
        return assignId;
    }

    public void setAssignId(Assignment assignId) {
        this.assignId = assignId;
    }



    public Submission(int subId, String grade, String feedback, User studentId, Assignment assignId) {
        this.subId = subId;
        this.grade = grade;
        this.feedback = feedback;
        this.studentId = studentId;
        this.assignId = assignId;
    }

    public Submission() {
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
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

}
