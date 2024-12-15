package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.models.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Event> eventsList;

    public EventAdapter(List<Event> eventsList) {
        this.eventsList = eventsList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = eventsList.get(position);
        holder.tvTitle.setText(event.getTitle());
        holder.tvDate.setText(event.getDate() != null ? event.getDate() : "Нет данных");
        holder.tvTime.setText(event.getTime());
        holder.tvLocation.setText(event.getLocation() != null ? event.getLocation() : "Нет данных");
        holder.tvSpeaker.setText(event.getSpeaker() != null ? event.getSpeaker() : "Нет данных");
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDate, tvTime, tvLocation, tvSpeaker;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle); // Исправлено на tvTitle
            tvDate = itemView.findViewById(R.id.tvDate); // Исправлено на tvDate
            tvTime = itemView.findViewById(R.id.tvTime); // Исправлено на tvTime
            tvLocation = itemView.findViewById(R.id.tvLocation); // Исправлено на tvLocation
            tvSpeaker = itemView.findViewById(R.id.tvSpeaker); // Исправлено на tvSpeaker
        }
    }
}