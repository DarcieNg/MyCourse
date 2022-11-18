package com.tutorial.mycourse.subactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tutorial.mycourse.MainActivity;
import com.tutorial.mycourse.R;

public class UploadActivity extends AppCompatActivity {

    Button uploadFilebtn, uploadCancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        uploadFilebtn = findViewById(R.id.upload_btn);
        uploadCancelBtn = findViewById(R.id.file_cancel_btn);

        uploadFilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add behavior to upload file - add file to the list

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(UploadActivity.this);

                alertDialogBuilder
                        .setTitle("Upload File")
                        .setMessage("Do you wanna upload?")
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(UploadActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        }).create().show();
            }
        });

        uploadCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UploadActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}