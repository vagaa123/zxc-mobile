package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.models.FinancialOperation;

import java.util.List;

public class FinancialOperationsAdapter extends RecyclerView.Adapter<FinancialOperationsAdapter.FinancialOperationViewHolder> {

    private List<FinancialOperation> operationsList;

    public FinancialOperationsAdapter(List<FinancialOperation> operationsList) {
        this.operationsList = operationsList;
    }

    @NonNull
    @Override
    public FinancialOperationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_financial_operation, parent, false);
        return new FinancialOperationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FinancialOperationViewHolder holder, int position) {
        FinancialOperation operation = operationsList.get(position);
        holder.tvDescription.setText(operation.getDescription());
        holder.tvAmount.setText(String.format("%.2f", operation.getAmount()));
        holder.tvType.setText(operation.getType());
    }

    @Override
    public int getItemCount() {
        return operationsList.size();
    }

    static class FinancialOperationViewHolder extends RecyclerView.ViewHolder {
        TextView tvDescription, tvAmount, tvType;

        public FinancialOperationViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            tvType = itemView.findViewById(R.id.tvType);
        }
    }
}