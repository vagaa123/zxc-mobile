package com.example.myapplication.models;

import androidx.annotation.NonNull;

public class FinancialOperation {
    private String description;
    private double amount;
    private String type; // "Доход" или "Расход"

    // Конструктор
    public FinancialOperation(@NonNull String description, double amount, @NonNull String type) {
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    // Геттеры
    @NonNull
    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    @NonNull
    public String getType() {
        return type;
    }
}