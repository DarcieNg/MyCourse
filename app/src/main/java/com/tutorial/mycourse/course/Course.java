package com.tutorial.mycourse.course;

import java.io.File;
import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private List<File> files;

    public Course(String courseId, String courseName, List<File> files) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.files = files;
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

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
