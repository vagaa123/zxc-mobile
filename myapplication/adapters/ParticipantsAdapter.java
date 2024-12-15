package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.Participant;

import java.util.List;

public class ParticipantsAdapter extends RecyclerView.Adapter<ParticipantsAdapter.ParticipantViewHolder> {

    private List<Participant> participantsList;

    public ParticipantsAdapter(List<Participant> participantsList) {
        this.participantsList = participantsList;
    }

    @NonNull
    @Override
    public ParticipantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_participant, parent, false);
        return new ParticipantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParticipantViewHolder holder, int position) {
        Participant participant = participantsList.get(position);
        holder.tvName.setText("Имя: " + participant.getName());
        holder.tvEmail.setText("Email: " + participant.getEmail());
        holder.tvOrganization.setText("Организация: " + participant.getOrganization());
        holder.tvRole.setText("Роль: " + participant.getRole());
        holder.tvPaymentStatus.setText("Статус оплаты: " + participant.getPaymentStatus());
    }

    @Override
    public int getItemCount() {
        return participantsList.size();
    }

    static class ParticipantViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvEmail, tvOrganization, tvRole, tvPaymentStatus;

        public ParticipantViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvOrganization = itemView.findViewById(R.id.tvOrganization);
            tvRole = itemView.findViewById(R.id.tvRole);
            tvPaymentStatus = itemView.findViewById(R.id.tvPaymentStatus);
        }
    }
}