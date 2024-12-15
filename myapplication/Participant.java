package com.example.myapplication;

import androidx.annotation.NonNull;

public class Participant {
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String organization;
    @NonNull
    private String role; // Заменили "presentation" на "role"
    @NonNull
    private String paymentStatus;

    // Конструктор
    public Participant(int id, @NonNull String name, @NonNull String email, @NonNull String organization, @NonNull String role, @NonNull String paymentStatus) {
        if (name == null || email == null || organization == null || role == null || paymentStatus == null) {
            throw new IllegalArgumentException("Значения не могут быть null");
        }
        this.id = id;
        this.name = name;
        this.email = email;
        this.organization = organization;
        this.role = role;
        this.paymentStatus = paymentStatus;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    @NonNull
    public String getOrganization() {
        return organization;
    }

    @NonNull
    public String getRole() { // Заменили getPresentation на getRole
        return role;
    }

    @NonNull
    public String getPaymentStatus() {
        return paymentStatus;
    }

    // Метод toString
    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", organization='" + organization + '\'' +
                ", role='" + role + '\'' + // Заменили presentation на role
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}