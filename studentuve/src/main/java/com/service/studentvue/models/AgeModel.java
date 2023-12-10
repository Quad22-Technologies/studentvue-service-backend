package com.service.studentvue.models;

public class AgeModel {
    
    private String id;
    private Integer age;
    private String familyname_Id;

    public AgeModel(String id, Integer age, String familyname_Id) {
     this.id = id; 
     this.age = age;
     this.familyname_Id = familyname_Id; 
     }

     public AgeModel() {
	}

	//Getters and Setters - The get method returns the variable value, and the set method sets the value.
    public String getId() {
        return id;
    }
     public void setId(String uuid) {
        this.id = uuid;
    }

    public Integer getAge() {
        return age;
    }
     public void setAge(Integer age) {
        this.age = age;
    }

    public String getFamilyname_Id() {
        return familyname_Id;
    }
     public void setFamilyname_Id(String familyname_Id) {
        this.familyname_Id = familyname_Id;
    }


}
