package com.service.studentvue.models;

public class ClassGradeModel {
    private String id;
    private String studentId;
    private String teacherId;
    private String classNameId;

    private float grade;

    public ClassGradeModel(String id, String studentId, String teacherId, String classNameId, float grade) {
        this.id = id;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.classNameId = classNameId;
        this.grade = grade;
    }

    public ClassGradeModel() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassNameId() {
        return classNameId;
    }

    public void setClassNameId(String classNameId) {
        this.classNameId = classNameId;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
