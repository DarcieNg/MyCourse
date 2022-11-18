package com.tutorial.mycourse.course;

import com.tutorial.mycourse.file.FileList;

public class Course {
    private String courseId;
    private String courseName;
    private FileList files;
    boolean isChecked;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.files = new FileList();
        this.isChecked = false;
    }

    public FileList getFiles() {
        return files;
    }

    public void setFiles(FileList files) {
        this.files = files;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
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
}
