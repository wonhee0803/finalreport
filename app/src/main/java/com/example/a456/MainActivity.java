package com.example.a456;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.VolumeShaper;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.a456.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(v -> calculate());
        binding.buttonYes.setOnClickListener(v -> startSecondActivity());
        binding.buttonNo.setOnClickListener(v -> finish());

    }

    private void startSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);

        startActivity(intent);
    }

    private void calculate() {
        String leftValue = binding.editHeight.getText().toString();
        String rightValue = binding.editWeight.getText().toString();

        if (leftValue.isEmpty()) {
            Toast.makeText(this, "키를 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        if (rightValue.isEmpty()) {
            Toast.makeText(this, "몸무게를 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }
    }
    DecimalFormat formatter = new DecimalFormat("#.##");


}
