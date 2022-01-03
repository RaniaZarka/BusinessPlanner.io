package com.example.businessplannerio.model;

public class country {
    private Integer country_Id;
    private String country_name;

    public country() {
    }

    public country(Integer country_Id, String country_name) {
        this.country_Id = country_Id;
        this.country_name = country_name;
    }

    public Integer getCountry_Id() {
        return country_Id;
    }

    public void setCountry_Id(Integer country_Id) {
        this.country_Id = country_Id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
