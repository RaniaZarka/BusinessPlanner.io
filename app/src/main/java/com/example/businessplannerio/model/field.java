package com.example.businessplannerio.model;

public class field {
    private Integer field_Id;
    private String field_name;

    public field() {
    }

    public field(Integer field_Id, String field_name) {
        this.field_Id = field_Id;
        this.field_name = field_name;
    }

    public Integer getField_Id() {
        return field_Id;
    }

    public void setField_Id(Integer field_Id) {
        this.field_Id = field_Id;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }
}
