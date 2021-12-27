package com.example.businessplannerio.WebApi;
import com.example.businessplannerio.model.qualification;
import com.example.businessplannerio.model.sub_qualification;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServices {

    @GET("qualification")
    Call<List<qualification>> getAllQualification();

    @GET("sub_qualification/{qualification_Id}")
    Call<List<sub_qualification>>getSubQualificationById(@Path("qualification_Id")int qualification_Id);
}
