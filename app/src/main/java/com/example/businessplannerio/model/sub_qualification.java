package com.example.businessplannerio.model;

public class sub_qualification {

    private Integer qualification_Id;
    private String sub_qualification_name;
    private Integer sub_qualification_Id;

    public sub_qualification(Integer qualification_Id, String sub_qualification_name, Integer sub_qualification_Id) {
        this.qualification_Id = qualification_Id;
        this.sub_qualification_name = sub_qualification_name;
        this.sub_qualification_Id = sub_qualification_Id;
    }

    public Integer getQualification_Id() {
        return qualification_Id;
    }

    public void setQualification_Id(Integer qualification_Id) {
        this.qualification_Id = qualification_Id;
    }

    public String getSub_qualification_name() {
        return sub_qualification_name;
    }

    public void setSub_qualification_name(String sub_qualification_name) {
        this.sub_qualification_name = sub_qualification_name;
    }

    public Integer getSub_qualification_Id() {
        return sub_qualification_Id;
    }

    public void setSub_qualification_Id(Integer sub_qualification_Id) {
        this.sub_qualification_Id = sub_qualification_Id;
    }
}
