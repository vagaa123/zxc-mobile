package com.example.myapplication.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.adapters.FinancialOperationsAdapter;
import com.example.myapplication.models.FinancialOperation;

import java.util.ArrayList;
import java.util.List;

public class PaymentsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewOperations;
    private List<FinancialOperation> operationsList;
    private FinancialOperationsAdapter adapter;

    private EditText etDescription, etAmount;
    private RadioGroup rgType;
    private Button btnAddOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);
        setTitle("Управление финансами");

        recyclerViewOperations = findViewById(R.id.recyclerViewOperations);
        recyclerViewOperations.setLayoutManager(new LinearLayoutManager(this));

        operationsList = new ArrayList<>();
        adapter = new FinancialOperationsAdapter(operationsList);
        recyclerViewOperations.setAdapter(adapter);

        etDescription = findViewById(R.id.etDescription);
        etAmount = findViewById(R.id.etAmount);
        rgType = findViewById(R.id.rgType);
        btnAddOperation = findViewById(R.id.btnAddOperation);

        btnAddOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = etDescription.getText().toString().trim();
                String amountStr = etAmount.getText().toString().trim();
                String type = ((RadioButton) findViewById(rgType.getCheckedRadioButtonId())).getText().toString();

                if (description.isEmpty() || amountStr.isEmpty()) {
                    Toast.makeText(PaymentsActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                } else {
                    double amount = Double.parseDouble(amountStr);
                    FinancialOperation operation = new FinancialOperation(description, amount, type);
                    operationsList.add(operation);
                    adapter.notifyDataSetChanged();

                    // Очищаем поля ввода
                    etDescription.setText("");
                    etAmount.setText("");
                }
            }
        });
    }
}