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
import com.example.businessplannerio.model.country;
import com.example.businessplannerio.recyclingView.countryRecycleView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class country_Fragment extends Fragment {
    public static final String COUNTRY = "country";
    countryRecycleView adapter;
    Button done;
    ImageButton back;
    TextView viewExperience;


    public country_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAndShowAllCountry();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_country_, container, false);
        done = view.findViewById(R.id.countryDone);
        done.setOnClickListener(onCLickDone);
        back= view.findViewById(R.id.countryBack);
        back.setOnClickListener(onClickBack);

        return view;
    }
      public void getAndShowAllCountry() {

        ApiServices services = ApiUtils.getDataService();
        Call<List<country>> getAllCountryCall = services.getAllCountry();

        getAllCountryCall.enqueue(new Callback<List<country>>() {
            @Override
            public void onResponse(Call<List<country>> call, Response<List<country>> response) {
                Log.d(COUNTRY, " response is  " +response.raw().toString());

                if (response.isSuccessful()) {
                    List<country> allCountry = response.body();
                    Log.d(COUNTRY, "the countries are " + allCountry.toString());
                    populateRecycleView(allCountry);
                } else {
                    String message = response.code() + " " + response.message();
                    Log.d(COUNTRY, "the problem is: " + message);
                    //viewQualification.setText(message);
                }
            }
            @Override
            public void onFailure(Call<List<country>> call, Throwable t) {
                Log.e(COUNTRY, t.getMessage());
                //viewQualification.setText(t.getMessage());
            }
        });
    }

    private void populateRecycleView(List<country> allCountry) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.countryRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(),2));
        adapter = new countryRecycleView(requireContext(), allCountry);
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
            Navigation.findNavController(requireView()).navigate(R.id.mentor_list_Fragment2);
        }
    };

}