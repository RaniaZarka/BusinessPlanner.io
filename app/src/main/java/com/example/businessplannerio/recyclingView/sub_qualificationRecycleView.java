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
import com.example.businessplannerio.model.sub_qualification;

import java.util.List;

public class sub_qualificationRecycleView extends RecyclerView.Adapter<sub_qualificationRecycleView.MyViewHolder> {
    private List<sub_qualification> data;
    private final LayoutInflater mInflater;
    private sub_qualificationRecycleView.ItemClickListener mClickListener;
    private static final String LOG_TAG = "SQR";

    public sub_qualificationRecycleView(Context context, List<sub_qualification>data){
        this.data = data;
        this.mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public sub_qualificationRecycleView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= mInflater.inflate(R.layout.sub_qualification_recycler, parent,false);
        Log.d(LOG_TAG, view.toString());
        return new sub_qualificationRecycleView.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull sub_qualificationRecycleView.MyViewHolder holder, int position) {
        sub_qualification q= data.get(position);
        Log.d(LOG_TAG, "onBindViewHolder sub_qualification " + data.toString());
       holder.sub_qualificationTextView.setText(q.getSub_qualification_name());
    }

    @Override
    public int getItemCount() {
        int count = data.size();
        return count;
    }

    public interface ItemClickListener<T> {
        void onItemClick(View view, int position, sub_qualification qu);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView sub_qualificationTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sub_qualificationTextView = itemView.findViewById(R.id.sub_qualificationText);
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
