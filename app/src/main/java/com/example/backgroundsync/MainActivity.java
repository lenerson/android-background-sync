package com.example.backgroundsync;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.backgroundsync.workers.WorkersBuilder;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WorkersBuilder.build(getApplicationContext());
    }
}