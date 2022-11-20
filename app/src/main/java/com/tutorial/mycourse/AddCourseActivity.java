package com.tutorial.mycourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.tutorial.mycourse.course.Course;

public class AddCourseActivity extends AppCompatActivity {

    private Button button;
    private ImageButton backBtn;
    private EditText courseName, courseCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        button = findViewById(R.id.create_btn);
        backBtn = findViewById(R.id.back_home_btn);

        courseCode = findViewById(R.id.course_code_input);
        courseName = findViewById(R.id.course_name_input);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (courseCode.getText().length() > 0 && courseName.getText().length() > 0) {

                    // add new course to the list
                    MainActivity.courses.add(new Course(courseCode.getText().toString(), courseName.getText().toString(), ""));

                    String toastMessage = "Successfully uploaded";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();

                    Intent toHome = new Intent(AddCourseActivity.this, MainActivity.class);

                    // Run back to the main screen handler
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Call Intent
                            startActivity(toHome);
                            finish();
                        }
                    }, 200);

                } else {
                    String toastMessage = "Invalid input. Input must not be blank!";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }

            }
        });

        // Set event for cancel button to come back to the main screen/activity
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddCourseActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}