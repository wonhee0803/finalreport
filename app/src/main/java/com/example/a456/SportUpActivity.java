package com.example.a456;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a456.databinding.ActivityUpBinding;

public class SportUpActivity extends AppCompatActivity {
    private ActivityUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonBack.setOnClickListener(v -> finish());
    }
}
