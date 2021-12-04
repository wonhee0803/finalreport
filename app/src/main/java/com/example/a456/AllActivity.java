package com.example.a456;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a456.databinding.ActivityAllBinding;


public class AllActivity extends AppCompatActivity {
    private ActivityAllBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonBack.setOnClickListener(v -> finish());
        binding.button11.setOnClickListener(v-> startWeb1());
        binding.button2.setOnClickListener(v-> startWeb2());
        binding.button3.setOnClickListener(v-> startWeb3());
    }

    public void startWeb1() {
        String url = "https://www.youtube.com/watch?v=swRNeYw1JkY";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void startWeb2() {
        String url = "https://www.youtube.com/watch?v=4kZHHPH6heY";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void startWeb3() {
        String url = "https://www.youtube.com/watch?v=hSDnj9xiP6I";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}
