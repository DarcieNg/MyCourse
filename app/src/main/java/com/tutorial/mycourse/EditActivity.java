package com.tutorial.mycourse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tutorial.mycourse.R;
import com.tutorial.mycourse.course.Course;

public class EditActivity extends AppCompatActivity {

    private ImageButton backBtn;
    private FloatingActionButton submitBtn;
    private TextView header;
    private EditText editNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();
        final int position = intent.getIntExtra("position", 0);

        backBtn = findViewById(R.id.back_course_btn);
        submitBtn = findViewById(R.id.submit_fab);
        header = findViewById(R.id.file_edit);
        editNote = findViewById(R.id.edit_view);

        Course course = MainActivity.courses.get(position);

        header.setText(course.getCourseId() + " - " + course.getCourseName());
        editNote.setText(course.getNote());

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toCourse = new Intent(EditActivity.this, CourseActivity.class);
                toCourse.putExtra("position", position);
                startActivity(toCourse);
                finish();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save new updated data
                MainActivity.courses.get(position).setNote(editNote.getText().toString());

                // Back to CourseView
                Intent toCourse = new Intent(EditActivity.this, CourseActivity.class);
                toCourse.putExtra("position", position);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Call Intent
                        startActivity(toCourse);
                    }
                }, 200);
            }
        });
    }

    private void showSoftKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
            getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }
}