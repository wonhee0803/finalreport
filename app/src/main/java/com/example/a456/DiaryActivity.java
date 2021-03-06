package com.example.a456;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.a456.databinding.ActivityDiaryBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiaryActivity extends AppCompatActivity {
    private ActivityDiaryBinding binding;
    public  String selectedDate = null;
    public List<DiaryModel> array = new ArrayList<>();
    public DiaryModel item = new DiaryModel();
    public Gson gson = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDiaryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        binding.calendarView.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                binding.textDiary.setVisibility(View.VISIBLE);
                binding.divider.setVisibility(View.VISIBLE);
                binding.textDiary.setText(String.format("%d / %d / %d", year, month+1, dayOfMonth));
                selectedDate = ""+year+"-"+(month+1)+""+"-"+dayOfMonth+"";
                load();
            }
        });

        binding.buttonWrite.setOnClickListener(v -> startContentsActivity());
        binding.buttonReview.setOnClickListener(v -> startReviewActivity());
    }

    private void startReviewActivity() {
        Intent intent = new Intent(this, ReviewActivity.class);
        intent.putExtra("selectedDate", selectedDate);
        startActivity(intent);
    }

    private void startContentsActivity() {
        Intent intent = new Intent(this, ContentsActivity.class);
        intent.putExtra("selectedDate", selectedDate);
        startActivity(intent);
    }

    private void load() {
        gson = new Gson();
        String diaryJson = null;
        int dataCount = 0;
        int indexModel = 0;

        try {
            diaryJson = FileUtils.readFile(this, "diary.json");
            array = gson.fromJson(diaryJson, new TypeToken<List<DiaryModel>>() {}.getType());

            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).getDate().equals(selectedDate)) {
                    dataCount++;
                    indexModel = i;
                }
            }
        } catch (IOException e) {
//            e.printStackTrace();
        }

        if (dataCount == 0) {
            binding.buttonWrite.setVisibility(View.VISIBLE);
            binding.textTitle.setVisibility(View.INVISIBLE);
            binding.image.setVisibility(View.INVISIBLE);
            binding.buttonReview.setVisibility(View.INVISIBLE);
        } else {
            this.item = array.get(indexModel);
            binding.textTitle.setText("??????: "+item.getTitle());
            String imageString = item.getImage();
            Bitmap bitmap = FileUtils.getBitmapFromString(imageString);
            binding.image.setImageBitmap(bitmap);
            binding.textTitle.setVisibility(View.VISIBLE);
            binding.image.setVisibility(View.VISIBLE);
            binding.buttonReview.setVisibility(View.VISIBLE);
            binding.buttonWrite.setVisibility(View.INVISIBLE);
        }
    }

    private ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
        if (isGranted) {
            Toast.makeText(this, "????????? ?????????????????????", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "????????? ???????????? ??????????????? ????????? ???????????? ?????? ???????????????", Toast.LENGTH_SHORT).show();
            finish();
        }
    });
}