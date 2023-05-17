package com.example.learningmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    private int enrollId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId")
    private Course course;

    public int getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(int enrollId) {
        this.enrollId = enrollId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Enrollment(int enrollId, User user, Course course) {
        this.enrollId = enrollId;
        this.user = user;
        this.course = course;
    }

    public Enrollment() {
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollId=" + enrollId +
                ", user=" + user +
                ", course=" + course +
                '}';
    }
}
