package com.service.studentvue.models;

public class UserModel {
    private String id;

    private String firstname;
    private String lastname;

    private String address;
    private String city;
    private String state;
    private String zipcode;

    private boolean isTeacher;
    private boolean isStudent;
    private boolean isParent;

    public UserModel(String id, String firstname, String lastname,
                     String address, String city, String state, String zipcode,
                     boolean isTeacher, boolean isStudent, boolean isParent) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;

        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;

        this.isTeacher = isTeacher;
        this.isStudent = isStudent;
        this.isParent = isParent;
    }

    public UserModel() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }
}
