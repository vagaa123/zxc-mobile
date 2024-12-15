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

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> {

    private List<Event> eventsList;

    // Конструктор адаптера
    public EventsAdapter(List<Event> eventsList) {
        this.eventsList = eventsList;
    }

    // Создание ViewHolder'а
    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    // Привязка данных к ViewHolder'у
    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = eventsList.get(position);
        holder.tvTitle.setText(event.getTitle());
        holder.tvDate.setText(event.getDate() != null ? event.getDate() : "Нет данных");
        holder.tvTime.setText(event.getTime());
        holder.tvLocation.setText(event.getLocation() != null ? event.getLocation() : "Нет данных");
        holder.tvSpeaker.setText(event.getSpeaker() != null ? event.getSpeaker() : "Нет данных");
    }

    // Возвращает количество элементов в списке
    @Override
    public int getItemCount() {
        return eventsList.size();
    }

    // ViewHolder для элемента списка
    static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDate, tvTime, tvLocation, tvSpeaker;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvSpeaker = itemView.findViewById(R.id.tvSpeaker);
        }
    }
}