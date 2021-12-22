package com.example.businessplannerio.WebApi;

public class ApiUtils {

    private static final String BASE_URL= "https://webservices-businessplanner.azurewebsites.net/";

    public static ApiServices getDataService(){
        return RetrofitServices.getData(BASE_URL).create(ApiServices.class);
    }

}
