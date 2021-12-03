package com.example.a456;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a456.databinding.ActivityTrainingBinding;

public class TrainingActivity extends AppCompatActivity {
    private ActivityTrainingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrainingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonFood.setOnClickListener(v -> startFood1Activity());
        binding.buttonSport.setOnClickListener(v -> startSport1Activity());
        binding.buttonBack.setOnClickListener(v -> finish());
    }

    private void startFood1Activity() {
        Intent intent = new Intent(this, FoodActivity.class);

        startActivity(intent);
    }

    private void startSport1Activity() {
        Intent intent = new Intent(this, Sport1Activity.class);

        startActivity(intent);
    }

}
