package com.example.a456;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a456.databinding.ActivityUpBinding;


public class UpActivity extends AppCompatActivity {
    private ActivityUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonBack.setOnClickListener(v -> finish());
        binding.buttonUp1.setOnClickListener(v-> startWeb1());
        binding.buttonUp2.setOnClickListener(v-> startWeb2());
        binding.buttonUp3.setOnClickListener(v-> startWeb3());
    }

    public void startWeb1() {
        String url = "https://www.youtube.com/watch?v=rO_fj0e6epI";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void startWeb2() {
        String url = "https://www.youtube.com/watch?v=QqqZH3j_vH0";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void startWeb3() {
        String url = "https://www.youtube.com/watch?v=e1DHt9wfQOA";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}