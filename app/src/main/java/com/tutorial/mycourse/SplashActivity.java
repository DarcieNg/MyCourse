package com.tutorial.mycourse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

// Control behaviors of splash screen
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Set main activity as the returned screen for splash one using Intent
        Intent toHome = new Intent(SplashActivity.this, MainActivity.class);

        // Run the splash screen handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Call Intent
                startActivity(toHome, ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this).toBundle());
            }
        }, 4000);
    }
}