package com.example.a456;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a456.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(v -> bmi());
        binding.buttonYes.setOnClickListener(v -> startSecondActivity());
        binding.buttonNo.setOnClickListener(v -> showDialog());
    }

    private void startSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);

        startActivity(intent);
    }

    public void bmi() {
        String firstValue = binding.editHeight.getText().toString();
        String secondValue = binding.editWeight.getText().toString();

        if (firstValue.isEmpty()) {
            Toast.makeText(this, "키를 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        if (secondValue.isEmpty()) {
            Toast.makeText(this, "몸무게를 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        float height = Float.parseFloat(firstValue);
        float weight = Float.parseFloat(secondValue);
        float bmiValue = weight / ((height / 100) * (height / 100));

        String message = "";
        if (bmiValue <= 18.5) {
            message = "저체중입니다. 근육 키우는 게 시급합니다.";
        } else if (bmiValue <= 22.9) {
            message = "정상 체중입니다. 유지를 위해 꾸준한 운동관리가 필요합니다.";
        } else if (bmiValue <= 24.9) {
            message = "과체중입니다. 운동과 식당관리가 필요합니다.";
        } else if (bmiValue <= 29.9) {
            message = "위험체중입니다. 운동과 식당관리가 시급합니다.";
        } else if (bmiValue <= 34.9) {
            message = "비만입니다. 꾸준한 운동과 식당관리가 시급합니다.";
        } else {
            message = "고도비만입니다. 다이어트를 위한 전문적인 관리가 시급합니다.";
        }
        binding.textBmi.setText(message);
        binding.textBmi.setVisibility(View.VISIBLE);
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
