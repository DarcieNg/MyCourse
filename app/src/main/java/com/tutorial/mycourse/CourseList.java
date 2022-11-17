package com.tutorial.mycourse;

import java.util.ArrayList;
import java.util.List;

public class CourseList {

    public static List<Course> list;

    public CourseList() {
        this.list = new ArrayList<>();
//        this.list = getCourseList();
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

//    // Testing function
//    public List<Course> getCourseList() {
//
//        list.add(new Course("OENG1181", "Introduction to Professional Engineering Practice"));
//        list.add(new Course("MATH2481", "Mathematics Engineering"));
//        list.add(new Course("EEET2481", "Introduction to Electrical and Electronics Engineering"));
//        list.add(new Course("EEET2403", "Computing Engineering"));
//        list.add(new Course("OENG1181", "Introduction to Professional Engineering Practice"));
//        list.add(new Course("MATH2481", "Mathematics Engineering"));
//        list.add(new Course("EEET2481", "Introduction to Electrical and Electronics Engineering"));
//        list.add(new Course("EEET2403", "Computing Engineering"));
//        list.add(new Course("OENG1181", "Introduction to Professional Engineering Practice"));
//        list.add(new Course("MATH2481", "Mathematics Engineering"));
//        list.add(new Course("EEET2481", "Introduction to Electrical and Electronics Engineering"));
//        list.add(new Course("EEET2403", "Computing Engineering"));
//
//        return list;
//    }
}
