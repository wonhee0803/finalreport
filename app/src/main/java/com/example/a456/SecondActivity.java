package com.example.a456;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a456.databinding.ActivitySecondBinding;


public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonDiary.setOnClickListener(v -> startDiaryActivity());
        binding.buttonGym.setOnClickListener(v -> startGymActivity());
        binding.buttonTraining.setOnClickListener(v -> startTrainingActivity());
    }

    private void startDiaryActivity() {
        Intent intent = new Intent(this, DiaryActivity.class);

        startActivity(intent);
    }

    private void startGymActivity() {
        Intent intent = new Intent(this, MainFitness.class);

        startActivity(intent);
    }

    private void startTrainingActivity() {
        Intent intent = new Intent(this, TrainingActivity.class);

        startActivity(intent);
    }

}

