package com.tutorial.mycourse.course;

import java.util.ArrayList;
import java.util.List;

public class CourseList {

    public static List<Course> list;

    public CourseList() {
        this.list = new ArrayList<>();
    }

    public static List<Course> getList() {
        return list;
    }

    public static void setList(List<Course> list) {
        CourseList.list = list;
    }

    public static void addCourse(Course course) {
        list.add(course);
    }

}
