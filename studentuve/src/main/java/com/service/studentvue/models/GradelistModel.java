package com.service.studentvue.models;

//A model object is a Java object that represents, or models, an item in the application. in this case we are modeling Family Names
// Models are DTOs - Data transfer Objects

@Deprecated
public class GradelistModel {
    private Integer id;
    private String gradeNum;
    private String gradeName;

    // A constructor in Java is a special method that is used to initialize objects.
    // The constructor is called when an object of a class is created. It can be used to set initial values for object attributes
    // In this case we are initializing the Registration object
    public GradelistModel(Integer id, String gradeNum, String gradeName) {
        this.id = id; // Set the initial value for the class attribute id
        this.gradeNum = gradeNum; // Set the initial value for the class attribute firstname
        this.gradeName = gradeName;// Set the initial value for the class attribute lastname
    }

        //Getters and Setters - The get method returns the variable value, and the set method sets the value.
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(String gradeNum) {
        this.gradeNum = gradeNum;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}
