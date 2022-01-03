package com.example.businessplannerio.model;

public class mentor {

    private Integer mentor_Id;
    private String mentor_name;
    private String mentor_description;

    private String mentor_experience;
    private String mentor_education;
    private String mentor_pic;

    public mentor() {
    }

    public mentor(Integer mentor_Id, String mentor_name, String mentor_description, String mentor_experience, String mentor_education, String mentor_pic) {
        this.mentor_Id = mentor_Id;
        this.mentor_name = mentor_name;
        this.mentor_description = mentor_description;
        this.mentor_experience = mentor_experience;
        this.mentor_education = mentor_education;
        this.mentor_pic = mentor_pic;
    }

    public Integer getMentor_Id() {
        return mentor_Id;
    }

    public void setMentor_Id(Integer mentor_Id) {
        this.mentor_Id = mentor_Id;
    }

    public String getMentor_name() {
        return mentor_name;
    }

    public void setMentor_name(String mentor_name) {
        this.mentor_name = mentor_name;
    }

    public String getMentor_description() {
        return mentor_description;
    }

    public void setMentor_description(String mentor_description) {
        this.mentor_description = mentor_description;
    }

    public String getMentor_experience() {
        return mentor_experience;
    }

    public void setMentor_experience(String mentor_experience) {
        this.mentor_experience = mentor_experience;
    }

    public String getMentor_education() {
        return mentor_education;
    }

    public void setMentor_education(String mentor_education) {
        this.mentor_education = mentor_education;
    }

    public String getMentor_pic() {
        return mentor_pic;
    }

    public void setMentor_pic(String mentor_pic) {
        this.mentor_pic = mentor_pic;
    }

 }
