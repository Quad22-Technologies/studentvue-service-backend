package com.service.studentvue.models;

public class UserModel {

    private String id;

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    private String username;
    private String email;
    private String password; // Hashed representation
    private int salt; // password salt used when hashing

    private boolean isTeacher;
    private boolean isStudent;
    private boolean isParent;

    private String parentId; // UserID of the parent
    private String gradeLevelId;

    public UserModel(String id, String firstName, String lastName, String address,
                     String city, String state, String zipCode, String username, String email,
                     String password, int salt, boolean isTeacher, boolean isStudent, boolean isParent,
                     String parentId, String gradeLevelId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.username = username;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.isTeacher = isTeacher;
        this.isStudent = isStudent;
        this.isParent = isParent;
        this.parentId = parentId;
        this.gradeLevelId = gradeLevelId;
    }

    // empty constructor as well.
    public UserModel() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSalt() {
        return salt;
    }

    public void setSalt(int salt) {
        this.salt = salt;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getGradeLevelId() {
        return gradeLevelId;
    }

    public void setGradeLevelId(String gradeLevelId) {
        this.gradeLevelId = gradeLevelId;
    }
}
