package com.example.businessplannerio.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.businessplannerio.R;
import com.example.businessplannerio.WebApi.ApiServices;
import com.example.businessplannerio.WebApi.ApiUtils;
import com.example.businessplannerio.model.qualification;
import com.example.businessplannerio.recyclingView.qualificationRecycleView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class main_Fragment extends Fragment {
    public static final String MESSAGE = "message";
    qualificationRecycleView adapter;
    Button no_more_btn;
    TextView viewQualification;

    public main_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onStart() {
        super.onStart();
        getAndShowAllQualifications();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_, container, false);
        no_more_btn = view.findViewById(R.id.main_no_more);
        no_more_btn.setOnClickListener(onCLickNext);

        return view;
    }
    private void getAndShowAllQualifications() {

        ApiServices services = ApiUtils.getDataService();
        Call<List<qualification>> getAllqualificationCall = services.getAllQualification();

        getAllqualificationCall.enqueue(new Callback<List<qualification>>() {
            @Override
            public void onResponse(Call<List<qualification>> call, Response<List<qualification>> response) {
                Log.d(MESSAGE, response.raw().toString());

                if (response.isSuccessful()) {
                    List<qualification> allqualifications = response.body();
                    Log.d(MESSAGE,"the qualifications are "+ allqualifications.toString());
                    populateRecycleView(allqualifications);
                } else {
                    String message =response.code() + " " + response.message();
                    Log.d(MESSAGE, "the problem is: " + message);
                    //viewQualification.setText(message);
                }
            }


            @Override
            public void onFailure(Call<List<qualification>> call, Throwable t) {
                Log.e(MESSAGE, t.getMessage());
                viewQualification.setText(t.getMessage());
            }
        });


    }

    private void populateRecycleView(List<qualification> allqualifications) {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.qualificationRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter= new qualificationRecycleView(requireContext(), allqualifications);
        recyclerView.setAdapter(adapter);

        adapter.setClickListener((view, position, item) -> {

            Log.d(MESSAGE, "item is: " + item.toString());
            if(position==0){
                Navigation.findNavController(requireView()).navigate(R.id.business_development_Fragment2);
            }
            if(position==1){
                Navigation.findNavController(requireView()).navigate(R.id.law_Fragment2);
            }
             if(position==2){
                 Navigation.findNavController(requireView()).navigate(R.id.marketing_Fragment2);
             }
             if(position==3){
                 Navigation.findNavController(requireView()).navigate(R.id.economy_Fragment2);
             }
             if(position==4){
                 Navigation.findNavController(requireView()).navigate(R.id.sales_Fragment2);
             }
        });

    }
    private View findViewById(int id) {
        return getView().findViewById(id);
    }




    View.OnClickListener onCLickNext = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Navigation.findNavController(requireView()).navigate(R.id.experience_Fragment2);
        }
    };


}