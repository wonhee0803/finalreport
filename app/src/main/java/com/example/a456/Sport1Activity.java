package com.example.a456;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a456.databinding.ActivityAllBinding;
import com.example.a456.databinding.ActivityDownBinding;
import com.example.a456.databinding.ActivitySport1Binding;
import com.example.a456.databinding.ActivityUpBinding;

public class Sport1Activity extends AppCompatActivity {
    private ActivitySport1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySport1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonBack.setOnClickListener(v -> finish());
        binding.buttonUp.setOnClickListener(v -> startUpActivity());
        binding.buttonBack.setOnClickListener(v -> startBackActivity());
        binding.buttonAll.setOnClickListener(v -> startAllActivity());
    }

    private void startUpActivity() {
        Intent intent = new Intent(this, ActivityUpBinding.class);

        startActivity(intent);
    }

    private void startBackActivity() {
        Intent intent = new Intent(this, ActivityDownBinding.class);

        startActivity(intent);
    }

    private void startAllActivity() {
        Intent intent = new Intent(this, ActivityAllBinding.class);

        startActivity(intent);
    }
}
