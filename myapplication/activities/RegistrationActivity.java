package com.example.myapplication.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.example.myapplication.Participant;

import java.util.ArrayList;
import java.util.List;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etName, etEmail, etOrganization, etRole, etPaymentStatus; // Заменили etPresentation на etRole
    private Button btnRegister;

    // Список для хранения участников
    public static List<Participant> participantsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Регистрация участника");

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etOrganization = findViewById(R.id.etOrganization);
        etRole = findViewById(R.id.etRole); // Заменили etPresentation на etRole
        etPaymentStatus = findViewById(R.id.etPaymentStatus);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String organization = etOrganization.getText().toString().trim();
                String role = etRole.getText().toString().trim(); // Заменили presentation на role
                String paymentStatus = etPaymentStatus.getText().toString().trim();

                if (name.isEmpty() || email.isEmpty() || organization.isEmpty() || role.isEmpty() || paymentStatus.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                } else {
                    // Создаем нового участника и добавляем в список
                    Participant participant = new Participant(
                            participantsList.size() + 1, // Уникальный ID
                            name,
                            email,
                            organization,
                            role, // Заменили presentation на role
                            paymentStatus
                    );
                    participantsList.add(participant);

                    // Показываем сообщение об успешной регистрации
                    Toast.makeText(RegistrationActivity.this, "Участник зарегистрирован", Toast.LENGTH_SHORT).show();

                    // Очищаем поля ввода
                    etName.setText("");
                    etEmail.setText("");
                    etOrganization.setText("");
                    etRole.setText(""); // Заменили etPresentation на etRole
                    etPaymentStatus.setText("");
                }
            }
        });
    }
}