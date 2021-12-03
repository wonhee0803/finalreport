package com.example.a456;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a456.databinding.ActivitySecondBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        String message = intent.getStringExtra("EXTRA_MESSAGE");
        String name = intent.getStringExtra("NAME");
        Uri image = intent.getParcelableExtra("IMAGE");


        binding.buttonDiary.setOnClickListener(v -> startDiaryActivity());
        binding.buttonGym.setOnClickListener(v -> startGymActivity());
        binding.buttonTraining.setOnClickListener(v -> startTrainingActivity());
    }

    private void startDiaryActivity() {
        Intent intent = new Intent(this, SecondActivity.class);

        startActivity(intent);
    }

    private void startGymActivity() {
        Intent intent = new Intent(this, SecondActivity.class);

        startActivity(intent);
    }

    private void startTrainingActivity() {
        Intent intent = new Intent(this, TrainingActivity.class);

        startActivity(intent);
    }


    private String getTime() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String getTime = dateFormat.format(date);

        return getTime;
    }

}

