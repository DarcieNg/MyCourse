package com.tutorial.mycourse.subactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tutorial.mycourse.MainActivity;
import com.tutorial.mycourse.R;
import com.tutorial.mycourse.course.Course;

public class CourseFormActivity extends AppCompatActivity {

    Button createCourseBtn, cancelBtn;
    private EditText courseCodeInput, courseNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_form);

        createCourseBtn = findViewById(R.id.create_btn);
        cancelBtn = findViewById(R.id.cancel_btn);

        courseCodeInput = findViewById(R.id.course_code_input);
        courseNameInput = findViewById(R.id.course_name_input);

        // Set event for create and upload new course to Firebase
        createCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (courseCodeInput.getText().length() > 0 && courseNameInput.getText().length() > 0) {

                    // Add course to the course list
                    MainActivity.courses.addCourse(new Course(courseCodeInput.getText().toString(), courseNameInput.getText().toString()));

                    String toastMessage = "Successfully uploaded";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();

                    Intent toHome = new Intent(CourseFormActivity.this, MainActivity.class);

                    // Run back to the main screen handler
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Call Intent
                            startActivity(toHome);
                        }
                    }, 500);

                } else {
                    String toastMessage = "Invalid input. Input must not be blank!";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }

            }
        });

        // Set event for cancel button to come back to the main screen/activity
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseFormActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}