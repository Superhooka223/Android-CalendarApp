package com.example.classprojcalender;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.time.LocalDate;
import java.util.ArrayList;
class Cal_Adapter extends RecyclerView.Adapter<Cal_ViewHolder>
{
    private final ArrayList<LocalDate> days;

    private final OnItemListener onItemListener;

    public Cal_Adapter(ArrayList<LocalDate> days, OnItemListener onItemListener)
    {
        this.days = days;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public Cal_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cal_cell, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if(days.size() > 15)//then its a month view
            layoutParams.height = (int) (parent.getHeight() * 0.166666666);
        else //then its a week view
            layoutParams.height = (int) parent.getHeight();

        return new Cal_ViewHolder(view, onItemListener, days);
    }

    @Override
    public void onBindViewHolder(@NonNull Cal_ViewHolder holder, int position)
    {
        final LocalDate date = days.get(position);

        holder.dayOfMonth.setText(String.valueOf(date.getDayOfMonth()));

        if(date.equals(Cal_Utils.selectedDate))
            holder.parentView.setBackgroundColor(Color.LTGRAY);

        if(date.getMonth().equals(Cal_Utils.selectedDate.getMonth()))
            holder.dayOfMonth.setTextColor(Color.BLACK);
        else
            holder.dayOfMonth.setTextColor(Color.LTGRAY);
    }

    @Override
    public int getItemCount()
    {
        return days.size();
    }
    public interface  OnItemListener
    {
        void onItemClick(int position, LocalDate date);
    }
}

