package com.example.businessplannerio.model;

import java.io.Serializable;

public class qualification implements Serializable {

    private Integer qualification_Id;
    private String qualification_name;

    public qualification(Integer qualification_Id, String qualification_name) {
        this.qualification_Id = qualification_Id;
        this.qualification_name = qualification_name;
    }

    public qualification(){}

    public Integer getQualification_Id() {
        return qualification_Id;
    }

    public void setQualification_Id(Integer qualification_Id) {
        this.qualification_Id = qualification_Id;
    }

    public String getQualification_name() {
        return qualification_name;
    }

    public void setQualification_name(String qualification_name) {
        this.qualification_name = qualification_name;
    }
}
