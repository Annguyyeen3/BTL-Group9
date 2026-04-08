package com.example.btl_group9.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_group9.R;
import com.example.btl_group9.models.Showtime;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class ShowtimeAdapter extends RecyclerView.Adapter<ShowtimeAdapter.ShowtimeViewHolder> {

    private List<Showtime> showtimeList;
    private OnShowtimeClickListener listener;

    public interface OnShowtimeClickListener {
        void onShowtimeClick(Showtime showtime);
    }

    public ShowtimeAdapter(List<Showtime> showtimeList, OnShowtimeClickListener listener) {
        this.showtimeList = showtimeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ShowtimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_showtime, parent, false);
        return new ShowtimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowtimeViewHolder holder, int position) {
        Showtime showtime = showtimeList.get(position);
        
        // Cần lấy tên rạp từ theater_id (hoặc hiển thị ID tạm thời)
        holder.tvTheaterName.setText("Theater ID: " + showtime.getTheater_id());
        
        if (showtime.getStart_time() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
            holder.tvStartTime.setText("Time: " + sdf.format(showtime.getStart_time().toDate()));
        }
        
        holder.tvPrice.setText(String.format(Locale.getDefault(), "Price: $%.2f", showtime.getPrice()));

        holder.itemView.setOnClickListener(v -> listener.onShowtimeClick(showtime));
    }

    @Override
    public int getItemCount() {
        return showtimeList.size();
    }

    public static class ShowtimeViewHolder extends RecyclerView.ViewHolder {
        TextView tvTheaterName, tvStartTime, tvPrice;

        public ShowtimeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTheaterName = itemView.findViewById(R.id.tvTheaterName);
            tvStartTime = itemView.findViewById(R.id.tvStartTime);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
