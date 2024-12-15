package com.example.myapplication.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class SyncActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button syncButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);
        setTitle("Синхронизация данных");

        progressBar = findViewById(R.id.progressBar); // Убедитесь, что ProgressBar существует в макете
        syncButton = findViewById(R.id.syncButton);

        syncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE); // Показываем индикатор
                syncData();
            }
        });
    }

    private void syncData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    // Логика синхронизации данных
                    Toast.makeText(SyncActivity.this, "Синхронизация завершена", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(SyncActivity.this, "Ошибка синхронизации: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                } finally {
                    progressBar.setVisibility(View.GONE); // Скрываем индикатор
                }
            }
        }, 2000); // Задержка 2 секунды
    }
}