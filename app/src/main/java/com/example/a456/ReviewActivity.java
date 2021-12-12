package com.example.a456;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a456.databinding.ActivityReviewBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

public class ReviewActivity extends AppCompatActivity {
    private ActivityReviewBinding binding;
    public List<DiaryModel> array = null;
    public Gson gson = null;
    public String selectedDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        gson = new Gson();
        String diaryJson = null;
        try {
            diaryJson = FileUtils.readFile(this, "diary.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        array = gson.fromJson(diaryJson, new TypeToken<List<DiaryModel>>() {}.getType());

        Intent intent = getIntent();
        selectedDate = intent.getStringExtra("selectedDate");
        binding.textDiary.setText(selectedDate+" 다이어리");
        binding.buttonBack.setOnClickListener(v -> startDiaryActivity());
        binding.buttonChange.setOnClickListener(v -> startContentsActivity());
        binding.buttonDelete.setOnClickListener(v -> {
            deleteDiary();
            startDiaryActivity();
        });

        for (DiaryModel diaryModel: array) {
            if (diaryModel.getDate().equals(selectedDate)) {
                binding.textTitle.setText(diaryModel.getTitle());
                binding.textContents1.setText(diaryModel.getText());
                binding.textEvaluation.setText(diaryModel.getEvaluation());
                String imageString = diaryModel.getImage();
                Bitmap bitmap = FileUtils.getBitmapFromString(imageString);
                binding.image.setImageBitmap(bitmap);
            }
        }
    }

    private void deleteDiary() {
        for (DiaryModel diaryModel: array) {
            if (diaryModel.getDate().equals(selectedDate)) {
                array.remove(diaryModel);
                String jsonString = gson.toJson(array);
                FileUtils.writeFile(this, "diary.json", jsonString);
            }
        }
    }

    private void startContentsActivity() {
        Intent intent = new Intent(this, ContentsActivity.class);
        intent.putExtra("selectedDate", selectedDate);
        startActivity(intent);
    }

    private void startDiaryActivity() {
        Intent intent = new Intent(this, DiaryActivity.class);
        startActivity(intent);
    }

}
