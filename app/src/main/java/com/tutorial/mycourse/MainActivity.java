package com.tutorial.mycourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.tutorial.mycourse.course.Course;
import com.tutorial.mycourse.course.CourseAdapter;
import com.tutorial.mycourse.course.CourseRecyclerInterface;

import java.util.ArrayList;

// Control behaviors of main activity
public class MainActivity extends AppCompatActivity implements CourseRecyclerInterface {

    private RecyclerView rcvCourse;
    private CourseAdapter courseAdapter;

    public static ArrayList<Course> courses = new ArrayList<>();

    String[] docName = {
            "Computer_Systems_I.pdf",
            "Algorithmics.pdf",
            "Data_Management.pdf",
            "Interaction_Design.pdf",
            "Cybersecurity"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        setDataForCourse();

        rcvCourse = findViewById(R.id.rcv_course);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCourse.setLayoutManager(linearLayoutManager);

        courseAdapter = new CourseAdapter(this, courses, this);

        courseAdapter.setData(courses);
        rcvCourse.setAdapter(courseAdapter);
    }

    private void setDataForCourse() {
        String[] coursesName = getResources().getStringArray(R.array.courses_name);
        String[] coursesCode = getResources().getStringArray(R.array.courses_code);

        for (int i = 0; i < coursesCode.length; i++) {
            courses.add(new Course(coursesCode[i], coursesName[i], docName[i]));
        }
    }

    @Override
    public void onClickCourse(int position) {
        Intent intent = new Intent(MainActivity.this, CourseActivity.class);

        intent.putExtra("position", position);
        startActivity(intent);
    }
}