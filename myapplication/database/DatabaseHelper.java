package com.example.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ConferenceManager.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Participants (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT, " +
                "Email TEXT, " +
                "Organization TEXT, " +
                "Presentation TEXT, " +
                "PaymentStatus TEXT)");

        // Добавляем индекс для столбца Email
        db.execSQL("CREATE INDEX idx_email ON Participants(Email)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Participants");
        onCreate(db);
    }

    // Метод для добавления участника
    public void addParticipant(String name, String email, String organization, String presentation) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name", name);
        values.put("Email", email);
        values.put("Organization", organization);
        values.put("Presentation", presentation);
        values.put("PaymentStatus", "Не оплачено");

        try {
            db.insertOrThrow("Participants", null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

    // Метод для обновления статуса оплаты участника
    public void updateParticipantPaymentStatus(int id, String paymentStatus) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("PaymentStatus", paymentStatus);

        try {
            db.update("Participants", values, "ID = ?", new String[]{String.valueOf(id)});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

    // Метод для удаления участника
    public void deleteParticipant(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete("Participants", "ID = ?", new String[]{String.valueOf(id)});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

    // Метод для получения всех участников
    public Cursor getParticipants() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM Participants", null);
    }
}