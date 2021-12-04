package com.example.a456;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a456.databinding.ActivityDownBinding;


public class DownActivity extends AppCompatActivity {
    private ActivityDownBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDownBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonBack3.setOnClickListener(v -> finish());
        binding.button6.setOnClickListener(v-> startWeb1());
        binding.button10.setOnClickListener(v-> startWeb2());
        binding.button12.setOnClickListener(v-> startWeb3());
    }

    public void startWeb1() {
        String url = "https://www.youtube.com/watch?v=wHFSoOklltA";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void startWeb2() {
        String url = "https://www.youtube.com/watch?v=cMH7D4PJM0I";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void startWeb3() {
        String url = "https://www.youtube.com/watch?v=wNXXc1zBYYw";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}

