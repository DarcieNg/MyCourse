package com.tutorial.mycourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

// Control behaviors of main activity
public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvCourse;
    private CourseAdapter courseAdapter;

    FloatingActionButton addCourseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        rcvCourse = findViewById(R.id.rcv_course);
        courseAdapter = new CourseAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCourse.setLayoutManager(linearLayoutManager);

        courseAdapter.setData(getCourseList());
        rcvCourse.setAdapter(courseAdapter);

        addCourseBtn = (FloatingActionButton) findViewById(R.id.fab);

        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CourseFormActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private List<Course> getCourseList() {
        List<Course> list = new ArrayList<>();
        list.add(new Course("OENG1181", "Introduction to Professional Engineering Practice"));
        list.add(new Course("MATH2481", "Mathematics Engineering"));
        list.add(new Course("EEET2481", "Introduction to Electrical and Electronics Engineering"));
        list.add(new Course("EEET2403", "Computing Engineering"));
        list.add(new Course("OENG1181", "Introduction to Professional Engineering Practice"));
        list.add(new Course("MATH2481", "Mathematics Engineering"));
        list.add(new Course("EEET2481", "Introduction to Electrical and Electronics Engineering"));
        list.add(new Course("EEET2403", "Computing Engineering"));
        list.add(new Course("OENG1181", "Introduction to Professional Engineering Practice"));
        list.add(new Course("MATH2481", "Mathematics Engineering"));
        list.add(new Course("EEET2481", "Introduction to Electrical and Electronics Engineering"));
        list.add(new Course("EEET2403", "Computing Engineering"));

        return list;
    }
}