package com.tutorial.mycourse;

import static com.tutorial.mycourse.CourseList.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
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

    public static final String messageId = "push_notification_id";

    FloatingActionButton addCourseBtn;

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

        addCourseBtn = (FloatingActionButton) findViewById(R.id.fab);

        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CourseFormActivity.class);
                startActivity(intent);
                finish();
            }
        });

        createChannelNotification();
    }

    private void createChannelNotification() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(messageId, "Push_Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificationChannel);
        }
    }


}