package com.service.studentvue.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.service.studentvue.services.GradeLevelService;
import com.service.studentvue.services.UserService;

public class StudentModel {
    private String id;
    private String userId;

    private String gradeLevelId;
    private String parentId; // can be null

    public StudentModel(String ID, String userId, String gradeLevelId, String parentId) {
        this.id = ID;
        this.userId = userId;
        this.gradeLevelId = gradeLevelId;
        this.parentId = parentId;
    }

    // TODO: change parentID to an actual parent when those have a model.
    public StudentModel(String ID, UserModel user, GradeLevelModel grade, String parentId) {
        this.id = ID;
        this.userId = user.getId();
        this.gradeLevelId = grade.getId();
        this.parentId = parentId;
    }
    public StudentModel() {}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGradeLevelId() {
        return gradeLevelId;
    }

    public void setGradeLevelId(String gradeLevelId) {
        this.gradeLevelId = gradeLevelId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    // additional getters used to get the data that those id's refer to.
    @JsonIgnore
    public UserModel getUser(UserService userService) {
        if (userId == null)
            return null;
        return userService.findById(userId);
    }

    @JsonIgnore
    public GradeLevelModel getGradeLevel(GradeLevelService gradeLevelService) {
        if (gradeLevelId == null)
            return null;
        return gradeLevelService.findById(userId);
    }
}
