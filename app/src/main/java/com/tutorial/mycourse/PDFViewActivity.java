package com.tutorial.mycourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.File;

public class PDFViewActivity extends AppCompatActivity {

    File file;
    private PDFView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfview);

        view = findViewById(R.id.file);
        view.fromAsset(file.getName())
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }
}