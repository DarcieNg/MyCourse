package com.tutorial.mycourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tutorial.mycourse.course.Course;

public class CourseActivity extends AppCompatActivity {

    private ImageButton button;
    private FloatingActionButton editBtn;
    private TextView courseName, courseNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        button = findViewById(R.id.back_btn);
        editBtn = findViewById(R.id.edit_fab);
        courseName = findViewById(R.id.course_name);
        courseNote = findViewById(R.id.text_view);

        Intent intent = getIntent();
        final int position = intent.getIntExtra("position", 0);

        Course course = MainActivity.courses.get(position);
        courseName.setText(course.getCourseId() + " - " + course.getCourseName());
        courseNote.setText(MainActivity.courses.get(position).getNote());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(CourseActivity.this, MainActivity.class);
                startActivity(toHome);
                finish();
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toEdit = new Intent(CourseActivity.this, EditActivity.class);
                toEdit.putExtra("position", position);
                startActivity(toEdit);
            }
        });






    }
}

