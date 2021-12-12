package com.example.a456;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a456.databinding.ActivitySport1Binding;


public class Sport1Activity extends AppCompatActivity {
    private ActivitySport1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySport1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonBack.setOnClickListener(v -> finish());
        binding.buttonUp.setOnClickListener(v -> startUpActivity());
        binding.buttonDown.setOnClickListener(v -> startBackActivity());
        binding.buttonAll.setOnClickListener(v -> startAllActivity());
    }

    private void startUpActivity() {
        Intent intent = new Intent(this, UpActivity.class);

        startActivity(intent);
    }

    private void startBackActivity() {
        Intent intent = new Intent(this, DownActivity.class);

        startActivity(intent);
    }

    private void startAllActivity() {
        Intent intent = new Intent(this, AllActivity.class);

        startActivity(intent);
    }
}
