package com.example.a456;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a456.databinding.ActivityFood1Binding;


public class Food1Activity extends AppCompatActivity {
    private ActivityFood1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFood1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonBack.setOnClickListener(v -> finish());
        binding.button1.setOnClickListener(v-> startWeb1());
        binding.button2.setOnClickListener(v-> startWeb2());
        binding.button3.setOnClickListener(v-> startWeb3());
        binding.button4.setOnClickListener(v-> startWeb4());
        binding.button5.setOnClickListener(v-> startWeb5());
    }

    public void startWeb1() {
        String url = "https://www.naver.com/";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void startWeb2() {
        String url = "https://www.naver.com/";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void startWeb3() {
        String url = "https://www.naver.com/";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void startWeb4() {
        String url = "https://www.naver.com/";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void startWeb5() {
        String url = "https://www.naver.com/";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}
