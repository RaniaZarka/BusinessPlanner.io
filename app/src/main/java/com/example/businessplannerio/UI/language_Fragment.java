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
import com.example.businessplannerio.model.language;
import com.example.businessplannerio.model.sub_qualification;
import com.example.businessplannerio.recyclingView.languageRecycleView;
import com.example.businessplannerio.recyclingView.sub_qualificationRecycleView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class language_Fragment extends Fragment {

    public static final String LANGUAGE = "language";
    languageRecycleView adapter;
    Button done;
    ImageButton back;
    TextView viewSubQualification;

    public language_Fragment() {
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
        View view=inflater.inflate(R.layout.fragment_language_, container, false);
        done = view.findViewById(R.id.languageDone);
        done.setOnClickListener(onCLickDone);
        back= view.findViewById(R.id.languageBack);
        back.setOnClickListener(onClickBack);
        getAndShowAllLanguages();
        return view;
    }

    public void getAndShowAllLanguages() {

        ApiServices services = ApiUtils.getDataService();
        Call<List<language>> getAllLanguageCall = services.getAllLanguages();

        getAllLanguageCall.enqueue(new Callback<List<language>>() {
            @Override
            public void onResponse(Call<List<language>> call, Response<List<language>> response) {
                Log.d(LANGUAGE, " response is  " +response.raw().toString());

                if (response.isSuccessful()) {
                    List<language> allLanguages = response.body();
                    Log.d(LANGUAGE, "the languages are " + allLanguages.toString());
                    populateRecycleView(allLanguages);
                } else {
                    String message = response.code() + " " + response.message();
                    Log.d(LANGUAGE, "the problem is: " + message);
                    //viewQualification.setText(message);
                }
            }


            @Override
            public void onFailure(Call<List<language>> call, Throwable t) {
                Log.e(LANGUAGE, t.getMessage());
                //viewQualification.setText(t.getMessage());
            }
        });
    }

    private void populateRecycleView(List<language> allLanguages) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.languageRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(),2));
        adapter = new languageRecycleView(requireContext(), allLanguages);
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
            Navigation.findNavController(requireView()).navigate(R.id.country_Fragment2);
        }
    };

}