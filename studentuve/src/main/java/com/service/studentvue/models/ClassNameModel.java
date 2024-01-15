package com.service.studentvue.models;

public class ClassNameModel {
    private String id;
    private String name;
    private String roomNumber;
    private String teacherId;

    public ClassNameModel(String id, String name, String roomNumber, String teacherId) {
        this.id = id;
        this.name = name;
        this.roomNumber = roomNumber;
        this.teacherId = teacherId;
    }

    public ClassNameModel() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
