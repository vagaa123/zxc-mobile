package com.example.myapplication.models;

import androidx.annotation.NonNull;

public class Event {
    private String title;
    private String description;
    private String time;
    private String date;
    private String location;
    private String speaker; // Добавляем поле спикера

    // Конструктор
    public Event(@NonNull String title, @NonNull String description, @NonNull String time, @NonNull String date, @NonNull String location, @NonNull String speaker) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.date = date;
        this.location = location;
        this.speaker = speaker; // Инициализируем спикера
    }

    // Геттеры
    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    @NonNull
    public String getTime() {
        return time;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    @NonNull
    public String getLocation() {
        return location;
    }

    @NonNull
    public String getSpeaker() { // Добавляем геттер для спикера
        return speaker;
    }
}