package com.tutorial.mycourse.course;

import java.io.File;
import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private String file;

    public Course(String courseId, String courseName, String file) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.file = file;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
