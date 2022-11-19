package com.tutorial.mycourse;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.github.barteksc.pdfviewer.PDFView;

public class CourseActivity extends AppCompatActivity {

    PDFView view;
//    WebView view;
    private ProgressBar progressBar;
    private ImageButton button;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        view = findViewById(R.id.view);
        button = findViewById(R.id.back_btn);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

//        view.getSettings().setJavaScriptEnabled(true);
//
//        view.getSettings().setAllowFileAccessFromFileURLs(true);
//        view.getSettings().setAllowUniversalAccessFromFileURLs(true);
//
//        view.getSettings().setBuiltInZoomControls(true);
//        view.getSettings().setDisplayZoomControls(false);
//        view.setWebChromeClient(new WebChromeClient());

        Intent intent = getIntent();
        final int position = intent.getIntExtra("position", 0);

        view.fromAsset(MainActivity.courses.get(position).getFile());
        //        view.setWebViewClient(new WebViewClient(){
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
////                String name = "file://app/src/main/assets/" + MainActivity.courses.get(position).getFile();
//                view.loadUrl("file://app/src/main/assets/" + MainActivity.courses.get(position).getFile() + "");
////                view.loadUrl("https://docs.google.com/document/d/1OIcQ8dJ_FAhdkirU94M29-ZbNZ4oQs1LbWF3Nz-mq_U/edit#");
//                progressBar.setVisibility(View.GONE);
//            }
//        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(CourseActivity.this, MainActivity.class);
                startActivity(toHome);
            }
        });






    }
}

