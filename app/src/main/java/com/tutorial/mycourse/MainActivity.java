package com.tutorial.mycourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tutorial.mycourse.course.Course;
import com.tutorial.mycourse.course.CourseAdapter;
import com.tutorial.mycourse.course.CourseRecyclerInterface;

import java.util.ArrayList;

// Control behaviors of main activity
public class MainActivity extends AppCompatActivity implements CourseRecyclerInterface {

    private RecyclerView rcvCourse;
    private CourseAdapter courseAdapter;

    // button navigating to create new course activity
    private FloatingActionButton button;

    public static ArrayList<Course> courses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // Sample data calling
        if (courses.isEmpty()) {
            setDataForCourse();
        }

        // handle adapter for course list
        rcvCourse = findViewById(R.id.rcv_course);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCourse.setLayoutManager(linearLayoutManager);
        courseAdapter = new CourseAdapter(this, courses, this);
        courseAdapter.setData(courses);
        rcvCourse.setAdapter(courseAdapter);

        // handle button
        button = findViewById(R.id.fab);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCourseActivity.class);
                startActivity(intent);
            }
        });
    }

    // Testing data
    private void setDataForCourse() {
        String[] coursesName = getResources().getStringArray(R.array.courses_name);
        String[] coursesCode = getResources().getStringArray(R.array.courses_code);
        String[] coursesNote = getResources().getStringArray(R.array.courses_note);

        for (int i = 0; i < coursesCode.length; i++) {
            courses.add(new Course(coursesCode[i], coursesName[i], coursesNote[i]));
        }
    }

    @Override
    public void onClickCourse(int position) {
        Intent intent = new Intent(MainActivity.this, CourseActivity.class);

        intent.putExtra("position", position);
        startActivity(intent);
    }
}