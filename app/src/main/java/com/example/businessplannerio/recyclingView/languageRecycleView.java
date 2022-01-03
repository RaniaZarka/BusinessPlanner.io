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
import com.example.businessplannerio.model.language;
import com.example.businessplannerio.model.qualification;

import java.util.List;

public class languageRecycleView extends RecyclerView.Adapter<languageRecycleView.MyViewHolder> {
    private List<language> data;
    private final LayoutInflater mInflater;
    private languageRecycleView.ItemClickListener mClickListener;
    private static final String LOG_TAG = "Language";

    public languageRecycleView(Context context, List<language>data){
        this.data = data;
        this.mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public languageRecycleView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= mInflater.inflate(R.layout.language_recycler, parent,false);
        Log.d(LOG_TAG, view.toString());
        return new languageRecycleView.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull languageRecycleView.MyViewHolder holder, int position) {
        language l= data.get(position);
        Log.d(LOG_TAG, "onBindViewHolder " + data.toString());
        holder.languageTextView.setText(l.getLanguage_name());
    }

    @Override
    public int getItemCount() {
        int count = data.size();
        return count;
    }
    public void setClickListener(languageRecycleView.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener<T> {
        void onItemClick(View view, int position, language l);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView languageTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            languageTextView = itemView.findViewById(R.id.languageText);
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


