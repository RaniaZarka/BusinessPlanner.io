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
import com.example.businessplannerio.model.country;

import java.util.List;

public class countryRecycleView extends RecyclerView.Adapter<countryRecycleView.MyViewHolder> {
        private List<country> data;
        private final LayoutInflater mInflater;
        private countryRecycleView.ItemClickListener mClickListener;
        private static final String LOG_TAG = "country";

    public countryRecycleView(Context context, List<country>data){
            this.data = data;
            this.mInflater = LayoutInflater.from(context);
        }


        @NonNull
        @Override
        public countryRecycleView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= mInflater.inflate(R.layout.country_recycler, parent,false);
            Log.d(LOG_TAG, view.toString());
            return new countryRecycleView.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull countryRecycleView.MyViewHolder holder, int position) {
            country c= data.get(position);
            Log.d(LOG_TAG, "onBindViewHolder country " + data.toString());
            holder.countryTextView.setText(c.getCountry_name());
        }

        @Override
        public int getItemCount() {
            int count = data.size();
            return count;
        }
        public void setClickListener(countryRecycleView.ItemClickListener itemClickListener) {
            this.mClickListener = itemClickListener;
        }

        public interface ItemClickListener<T> {
            void onItemClick(View view, int position, country c );
        }

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            final TextView countryTextView;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                countryTextView = itemView.findViewById(R.id.countryText);
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
