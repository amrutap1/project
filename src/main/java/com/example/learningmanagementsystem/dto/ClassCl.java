package com.example.learningmanagementsystem.dto;


import java.sql.Time;

public class ClassCl {
    int courseId;
    int teacherId;
    Time startTime;
    Time endTime;

    public ClassCl() {
    }

    public ClassCl(int courseId, int teacherId, Time startTime, Time endTime) {
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "ClassCl{" +
                "courseId=" + courseId +
                ", teacherId=" + teacherId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
