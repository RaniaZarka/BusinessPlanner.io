package com.example.businessplannerio.model;

public class language {

    private Integer language_Id;
    private String language_name;

    public language(Integer language_Id, String language_name) {
        this.language_Id = language_Id;
        this.language_name = language_name;
    }
    public language(){}

    public Integer getLanguage_Id() {
        return language_Id;
    }

    public void setLanguage_Id(Integer language_Id) {
        this.language_Id = language_Id;
    }

    public String getLanguage_name() {
        return language_name;
    }

    public void setLanguage_name(String language_name) {
        this.language_name = language_name;
    }
}
