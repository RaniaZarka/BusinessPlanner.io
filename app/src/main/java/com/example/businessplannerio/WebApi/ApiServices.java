package com.example.businessplannerio.WebApi;
import com.example.businessplannerio.model.qualification;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("qualification")
    Call<List<qualification>> getAllQualification();
}
