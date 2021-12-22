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
import com.example.businessplannerio.model.qualification;

import java.util.List;

public class qualificationRecycleView extends RecyclerView.Adapter<qualificationRecycleView.MyViewHolder> {
    private List<qualification> data;
 private final LayoutInflater mInflater;
 private ItemClickListener mClickListener;
    private static final String LOG_TAG = "QR";

 public qualificationRecycleView(Context context,List<qualification>data){
     this.data = data;
     this.mInflater = LayoutInflater.from(context);
 }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view= mInflater.inflate(R.layout.qualification_recycler, parent,false);
        Log.d(LOG_TAG, view.toString());
     return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull qualificationRecycleView.MyViewHolder holder, int position) {
         qualification q= data.get(position);
        Log.d(LOG_TAG, "onBindViewHolder " + data.toString());
         holder.qualificationTextView.setText(q.getQualification_name());
    }

    @Override
    public int getItemCount() {
        int count = data.size();
        return count;
    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener<T> {
        void onItemClick(View view, int position, qualification qu);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView qualificationTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            qualificationTextView = itemView.findViewById(R.id.qualificationText);
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

