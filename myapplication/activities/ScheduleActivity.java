package com.example.myapplication.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.adapters.EventAdapter;
import com.example.myapplication.models.Event;

import java.util.ArrayList;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {

    private RecyclerView recyclerViewEvents;
    private List<Event> eventsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        setTitle("Расписание");

        recyclerViewEvents = findViewById(R.id.recyclerViewEvents);
        recyclerViewEvents.setLayoutManager(new LinearLayoutManager(this));

        // Инициализация списка мероприятий
        eventsList = new ArrayList<>();
        eventsList.add(new Event("Открытие конференции", "Приветственное слово организаторов", "09:00", "2023-10-15", "Конференц-зал A", "Иван Иванов"));
        eventsList.add(new Event("Сессия 1: Технологии будущего", "Обсуждение новых технологий", "10:00", "2023-10-15", "Конференц-зал A", "Петр Петров"));
        eventsList.add(new Event("Перерыв", "Кофе-брейк", "11:30", "2023-10-15", "Фойе", "Нет"));
        eventsList.add(new Event("Сессия 2: Управление проектами", "Эффективные методы управления", "12:00", "2023-10-15", "Конференц-зал B", "Анна Сидорова"));
        eventsList.add(new Event("Обед", "Обед для участников", "13:30", "2023-10-15", "Ресторан", "Нет"));
        eventsList.add(new Event("Сессия 3: Искусственный интеллект", "Применение ИИ в бизнесе", "14:30", "2023-10-15", "Конференц-зал A", "Дмитрий Смирнов"));
        eventsList.add(new Event("Закрытие конференции", "Подведение итогов и награждение", "16:00", "2023-10-15", "Конференц-зал A", "Иван Иванов"));

        // Устанавливаем адаптер для RecyclerView
        EventAdapter adapter = new EventAdapter(eventsList);
        recyclerViewEvents.setAdapter(adapter);
    }
}