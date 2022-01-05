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
import com.example.businessplannerio.model.field;
import com.example.businessplannerio.recyclingView.fieldRecycleView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class field_Fragment extends Fragment {
    public static final String EXPERIENCE = "experience";
    fieldRecycleView adapter;
    Button done;
    ImageButton back;
    TextView viewExperience;

    public field_Fragment() {
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
        View view=inflater.inflate(R.layout.fragment_experience_, container, false);
        done = view.findViewById(R.id.experienceDone);
        done.setOnClickListener(onCLickDone);
        back= view.findViewById(R.id.experienceBack);
        back.setOnClickListener(onClickBack);
        getAndShowAllexperiences();
        return view;
    }
   public void getAndShowAllexperiences() {

        ApiServices services = ApiUtils.getDataService();
        Call<List<field>> getAllExperienceCall = services.getAllExperience();

        getAllExperienceCall.enqueue(new Callback<List<field>>() {
            @Override
            public void onResponse(Call<List<field>> call, Response<List<field>> response) {
                Log.d(EXPERIENCE, " response is  " +response.raw().toString());

                if (response.isSuccessful()) {
                    List<field> allExperience = response.body();
                    Log.d(EXPERIENCE, "the sub_qualifications are " + allExperience.toString());
                    populateRecycleView(allExperience);
                } else {
                    String message = response.code() + " " + response.message();
                    Log.d(EXPERIENCE, "the problem is: " + message);
                    //viewQualification.setText(message);
                }
            }


            @Override
            public void onFailure(Call<List<field>> call, Throwable t) {
                Log.e(EXPERIENCE, t.getMessage());
                //viewQualification.setText(t.getMessage());
            }
        });
    }

    private void populateRecycleView(List<field> allExperience) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.experienceRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(),2));
        adapter = new fieldRecycleView(requireContext(), allExperience);
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
            Navigation.findNavController(requireView()).navigate(R.id.language_Fragment2);
        }
    };

}