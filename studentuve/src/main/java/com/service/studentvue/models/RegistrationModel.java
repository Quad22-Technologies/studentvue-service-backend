package com.service.studentvue.models;

/* 
import java.util.UUID;
import jakarta.annotation.*;
*/


//A model object is a Java object that represents, or models, an item in the application. in this case we are modeling Family Names
// Models are DTOs - Data transfer Objects
public class RegistrationModel {// variables/attributes are set as private to make sure that "sensitive" data is hidden from users.
    // this is called Encapsulation
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String username;
    private String password;
    private String password2;
    private Integer gradelist;

    //A constructor in Java is a special method that is used to initialize objects.
    // The constructor is called when an object of a class is created. It can be used to set initial values for object attributes
    //In this case we are initializing the Registration object
    public RegistrationModel(String id, String firstName, String lastName, String address, String city, String state, String zipCode, String username, String password, String password2, Integer gradelist) {
        this.id = id; // Set the initial value for the class attribute id
        this.firstName = firstName; // Set the initial value for the class attribute firstname
        this.lastName = lastName;// Set the initial value for the class attribute lastname
        this.address = address;// Set the initial value for the class attribute user address
        this.city = city; //Set the initial value for the class attribute user city
        this.state = state; //Set the initial value for the class attribute user state
        this.zipCode = zipCode; //Set the initial value for the class attribute user zipcode
        this.username = username; //Set the initial value for the class attribute username
        this.password = password; //Set the initial value for the class attribute password
        this.password2 = password2; //Set the initial value for the class attribute password2
        this.gradelist = gradelist; //Set the initial value for the class attribute gradelist
    }

    public RegistrationModel() {
    }

    //Getters and Setters - The get method returns the variable value, and the set method sets the value.
    public String getId() {
        return id;
    }

    public void setId(String uuid) {
        this.id = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public Integer getGradelist() {
        return gradelist;
    }

    public void setGradelist(Integer gradelist) {
        this.gradelist = gradelist;
    }
}


