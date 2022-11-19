package com.tutorial.mycourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.tutorial.mycourse.course.CourseAdapter;
import com.tutorial.mycourse.course.CourseList;

// Control behaviors of main activity
public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvCourse;
    private CourseAdapter courseAdapter;


    public static CourseList courses = new CourseList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        rcvCourse = findViewById(R.id.rcv_course);
        courseAdapter = new CourseAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCourse.setLayoutManager(linearLayoutManager);

        courseAdapter.setData(courses.getList());
        rcvCourse.setAdapter(courseAdapter);
    }
}