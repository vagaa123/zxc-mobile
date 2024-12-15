package com.example.myapplication.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Главное меню");
    }

    // Общий метод для запуска активностей
    private void openActivity(Class<?> activityClass) {
        try {
            Intent intent = new Intent(this, activityClass);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); // Анимация
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, activityClass.getSimpleName() + " not found", Toast.LENGTH_SHORT).show();
            e.printStackTrace(); // Логирование ошибки
        }
    }

    // Метод для открытия RegistrationActivity
    public void openRegistration(View view) {
        openActivity(RegistrationActivity.class);
    }

    // Метод для открытия ScheduleActivity
    public void openSchedule(View view) {
        openActivity(ScheduleActivity.class);
    }

    // Метод для открытия PaymentsActivity
    public void openPayments(View view) {
        openActivity(PaymentsActivity.class);
    }

    // Метод для открытия ParticipantsListActivity
    public void openParticipantsList(View view) {
        openActivity(ParticipantsListActivity.class);
    }
}