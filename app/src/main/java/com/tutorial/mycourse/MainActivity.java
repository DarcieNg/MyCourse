package com.tutorial.mycourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.tutorial.mycourse.course.Course;
import com.tutorial.mycourse.course.CourseAdapter;

import java.util.ArrayList;

// Control behaviors of main activity
public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvCourse;
    private CourseAdapter courseAdapter;

    ArrayList<Course> courses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        rcvCourse = findViewById(R.id.rcv_course);
        courseAdapter = new CourseAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCourse.setLayoutManager(linearLayoutManager);

        courseAdapter.setData(courses);
        rcvCourse.setAdapter(courseAdapter);
    }

    private void setDataForCourse() {
        String[] coursesName = getResources().getStringArray(R.array.courses_name);
        String[] coursesCode = getResources().getStringArray(R.array.courses_code);

        for (int i = 0; i < coursesCode.length; i++) {

        }
    }
}