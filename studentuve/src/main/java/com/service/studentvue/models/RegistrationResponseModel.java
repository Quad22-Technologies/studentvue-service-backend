package com.service.studentvue.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.boot.jackson.JsonObjectSerializer;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RegistrationResponseModel {
    PASSWORDS_DONT_MATCH (false, "Password Don't Match"),
    PASSWORD_TOO_SHORT (false, "Password Too Short"),
    INVALID_EMAIL (false, "Invalid Email"),
    EMAIL_IN_USE (false, "Email Already In Use"),
    USERNAME_IN_USE (false, "User Already Exists"),
    UNEXPECTED_ERROR (false, "Unexpected Error"),
    EMPTY_FIELD (false, "One or More Fields Are Empty"),
    SUCCESS (true, "Success");


    private boolean success;
    private String response;

    RegistrationResponseModel(boolean success, String response) {
        this.success = success;
        this.response = response;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
