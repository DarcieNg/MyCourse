package com.tutorial.mycourse.course;

import java.io.File;
import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private String note;

    public Course(String courseId, String courseName, String note) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.note = note;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
