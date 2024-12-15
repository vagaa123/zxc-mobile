package com.example.myapplication.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.adapters.ParticipantsAdapter;

public class ParticipantsListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewParticipants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participants_list);
        setTitle("Список участников");

        recyclerViewParticipants = findViewById(R.id.recyclerViewParticipants);
        recyclerViewParticipants.setLayoutManager(new LinearLayoutManager(this));

        // Устанавливаем адаптер для RecyclerView
        ParticipantsAdapter adapter = new ParticipantsAdapter(RegistrationActivity.participantsList);
        recyclerViewParticipants.setAdapter(adapter);
    }
}