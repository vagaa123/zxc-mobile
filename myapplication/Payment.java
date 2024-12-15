package com.example.myapplication;

import androidx.annotation.NonNull;

public class Payment {
    private int id;
    private int participantId;
    private double amount;
    @NonNull
    private String paymentDate;
    @NonNull
    private String paymentMethod;
    @NonNull
    private String status;

    // Конструктор
    public Payment(int id, int participantId, double amount, @NonNull String paymentDate, @NonNull String paymentMethod, @NonNull String status) {
        if (paymentDate == null || paymentMethod == null || status == null) {
            throw new IllegalArgumentException("Значения не могут быть null");
        }
        this.id = id;
        this.participantId = participantId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public int getParticipantId() {
        return participantId;
    }

    public double getAmount() {
        return amount;
    }

    @NonNull
    public String getPaymentDate() {
        return paymentDate;
    }

    @NonNull
    public String getPaymentMethod() {
        return paymentMethod;
    }

    @NonNull
    public String getStatus() {
        return status;
    }

    // Сеттеры
    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentDate(@NonNull String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentMethod(@NonNull String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setStatus(@NonNull String status) {
        this.status = status;
    }

    // Метод toString
    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", participantId=" + participantId +
                ", amount=" + amount +
                ", paymentDate='" + paymentDate + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    // Методы equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (id != payment.id) return false;
        if (participantId != payment.participantId) return false;
        if (Double.compare(payment.amount, amount) != 0) return false;
        if (!paymentDate.equals(payment.paymentDate)) return false;
        if (!paymentMethod.equals(payment.paymentMethod)) return false;
        return status.equals(payment.status);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + participantId;
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + paymentDate.hashCode();
        result = 31 * result + paymentMethod.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
}