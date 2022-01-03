package com.example.businessplannerio.recyclingView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.businessplannerio.R;
import com.example.businessplannerio.model.field;

import java.util.List;

public class fieldRecycleView extends RecyclerView.Adapter<fieldRecycleView.MyViewHolder> {
    private List<field> data;
    private final LayoutInflater mInflater;
    private fieldRecycleView.ItemClickListener mClickListener;
    private static final String LOG_TAG = "experience";

    public fieldRecycleView(Context context, List<field>data){
        this.data = data;
        this.mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public fieldRecycleView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= mInflater.inflate(R.layout.experience_recycler, parent,false);
        Log.d(LOG_TAG, view.toString());
        return new fieldRecycleView.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull fieldRecycleView.MyViewHolder holder, int position) {
        field e= data.get(position);
        Log.d(LOG_TAG, "onBindViewHolder of experience " + data.toString());
        holder.experienceTextView.setText(e.getField_name());
        Log.d(LOG_TAG, "onBindViewHolder of experience " + e.getField_name());
    }

    @Override
    public int getItemCount() {
        int count = data.size();
        return count;
    }
    public void setClickListener(fieldRecycleView.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener<T> {
        void onItemClick(View view, int position, field e);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView experienceTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            experienceTextView = itemView.findViewById(R.id.experienceText);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                mClickListener.onItemClick(view, getAdapterPosition(), data.get(getAdapterPosition()));
            }
        }
    }
}



