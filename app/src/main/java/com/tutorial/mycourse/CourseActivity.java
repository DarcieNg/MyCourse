package com.tutorial.mycourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tutorial.mycourse.file.FileAdapter;
import com.tutorial.mycourse.file.FileList;
import com.tutorial.mycourse.subactivities.UploadActivity;

public class CourseActivity extends AppCompatActivity {

    private RecyclerView rcvFile;
    private FileAdapter fileAdapter;

    FloatingActionButton addFileBtn;

    public static FileList files = new FileList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_course);

        rcvFile = findViewById(R.id.rcv_file);
        fileAdapter = new FileAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvFile.setLayoutManager(linearLayoutManager);
        fileAdapter.setData(files.getList());

        rcvFile.setAdapter(fileAdapter);

        addFileBtn = (FloatingActionButton) findViewById(R.id.fab_course);

        addFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseActivity.this, UploadActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

