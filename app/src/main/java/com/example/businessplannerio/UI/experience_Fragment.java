package com.example.businessplannerio.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.businessplannerio.R;
import com.example.businessplannerio.recyclingView.sub_qualificationRecycleView;


public class experience_Fragment extends Fragment {
    public static final String EXPERIENCE = "law";
    sub_qualificationRecycleView adapter;
    Button done;
    ImageButton back;
    TextView viewSubQualification;


    public experience_Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =inflater.inflate(R.layout.fragment_experience_, container, false);

       return view;
    }
}