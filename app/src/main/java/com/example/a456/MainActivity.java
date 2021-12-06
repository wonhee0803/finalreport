package com.example.a456;

import androidx.appcompat.app.AlertDialog;
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
        binding.button.setOnClickListener(v -> bmi());
        binding.buttonYes.setOnClickListener(v -> startSecondActivity());
        binding.buttonNo.setOnClickListener(v -> showDialog());

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

        float left = Float.parseFloat(leftValue);
        float right = Float.parseFloat(rightValue);

        float result = 0;
        result = left / right;
    }

    public void bmi() {
        float bmiValue = 20.4f;

        String message = "";
        if (bmiValue < 10) {
            message = "저체중";
        } else if (bmiValue < 20) {
            message = "딱좋아";
        } else {
            message = "다이어트가 시급합니다";
        }
        binding.textBmi.setText(message);
    }

    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("앱을 종료하시겠습니까?")
                .setPositiveButton("Yes", (dialog, id) -> {
                    finish();
                })
                .setNegativeButton("No", (dialog, id) -> {
                    // do nothing
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }



}
