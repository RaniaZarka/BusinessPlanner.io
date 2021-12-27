package com.example.businessplannerio.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.businessplannerio.R;
import com.example.businessplannerio.WebApi.ApiServices;
import com.example.businessplannerio.WebApi.ApiUtils;
import com.example.businessplannerio.model.sub_qualification;
import com.example.businessplannerio.recyclingView.sub_qualificationRecycleView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class law_Fragment extends Fragment {
    public static final String LAW = "law";
    sub_qualificationRecycleView adapter;
    Button done;
    ImageButton back;
    TextView viewSubQualification;

    public law_Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAndShowAllSubQualification();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_law_, container, false);

        done = view.findViewById(R.id.lawDone);
        done.setOnClickListener(onCLickDone);
        back= view.findViewById(R.id.lawBack);
        back.setOnClickListener(onClickBack);
        return view;
    }
    public void getAndShowAllSubQualification() {

        ApiServices services = ApiUtils.getDataService();
        Call<List<sub_qualification>> getAllSub_Bus_qualificationCall = services.getSubQualificationById(2);

        getAllSub_Bus_qualificationCall.enqueue(new Callback<List<sub_qualification>>() {
            @Override
            public void onResponse(Call<List<sub_qualification>> call, Response<List<sub_qualification>> response) {
                Log.d(LAW, " response is  " +response.raw().toString());

                if (response.isSuccessful()) {
                    List<sub_qualification> allBusinessQualifications = response.body();
                    Log.d(LAW, "the sub_qualifications are " + allBusinessQualifications.toString());
                    populateRecycleView(allBusinessQualifications);
                } else {
                    String message = response.code() + " " + response.message();
                    Log.d(LAW, "the problem is: " + message);
                    //viewQualification.setText(message);
                }
            }


            @Override
            public void onFailure(Call<List<sub_qualification>> call, Throwable t) {
                Log.e(LAW, t.getMessage());
                //viewQualification.setText(t.getMessage());
            }
        });
    }

    private void populateRecycleView(List<sub_qualification> allBusinessqualifications) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lawRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(),2));
        adapter = new sub_qualificationRecycleView(requireContext(), allBusinessqualifications);
        recyclerView.setAdapter(adapter);

    }

    private View findViewById(int id) {
        return getView().findViewById(id);
    }

    View.OnClickListener onClickBack = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Navigation.findNavController(requireView()).navigate(R.id.main_Fragment2);
        }
    };
    View.OnClickListener onCLickDone = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Navigation.findNavController(requireView()).navigate(R.id.main_Fragment2);
        }
    };
}