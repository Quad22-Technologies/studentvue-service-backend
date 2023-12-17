package com.service.studentvue.models;

public class GradeLevelModel {
    private String id;
    private String abreviation;
    private String name;

    public GradeLevelModel(String id, String abreviation, String name) {
        this.id = id;
        this.abreviation = abreviation;
        this.name = name;
    }

    public GradeLevelModel() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
