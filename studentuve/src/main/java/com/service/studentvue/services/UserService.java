package com.service.studentvue.services;

import com.service.studentvue.models.RegistrationModel;
import com.service.studentvue.models.RegistrationResponseModel;
import com.service.studentvue.models.UserModel;
import com.service.studentvue.repositories.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    @Resource
    UserRepository _userRepository;

    public List<UserModel> findAll() {
        return _userRepository.findAll();
    }


    // note: we do not just have a "insertUser" method because we want someone to
    //  think about what kind of info they are inserting.
    /**Insert a user who information is already hashed.*/
    public UserModel insertHashedUser(UserModel user) {
        UUID uuid = UUID.randomUUID();
        user.setId(uuid.toString());
        return _userRepository.insertUser(user);
    }

    /**Insert a user who needs their information hashed.*/
    public UserModel insertUnhashedUser(UserModel user) {
        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(user.getPassword(), salt);
        user.setPassword(hashedPassword);

        return insertHashedUser(user);
    }

    // TODO:
    // Taken from an online example. There are likely options already present in Spring Boot.
    // I will take some more time to find resources about that
    private boolean validateEmail(String email) {
        // complicated regex string
        // look here for explanation: https://emaillistvalidation.com/blog/email-validation-in-javascript-using-regular-expressions-the-ultimate-guide/
        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean checkFullFields(RegistrationModel regData){
        return regData.getFirstName() != "" &&
                regData.getLastName() != "" &&
                regData.getAddress() != "" &&
                regData.getCity() != "" &&
                regData.getState()!= "" &&
                regData.getZipCode() != "" &&
                regData.getUsername() != "" &&
                regData.getEmail() != "" &&
                regData.getPassword() != "" &&
                regData.getPassword2() != "" &&
                regData.getGradelist() != "";
    }

    public RegistrationResponseModel registerUser(RegistrationModel regData) {
        // check all data is filled out
        if (!checkFullFields(regData))
            return RegistrationResponseModel.EMPTY_FIELD;

        // check password matches and minimum length
        if (!regData.getPassword().equals(regData.getPassword2()))
            return RegistrationResponseModel.PASSWORDS_DONT_MATCH;

        if (regData.getPassword().length() < 8)
            return RegistrationResponseModel.PASSWORD_TOO_SHORT;

        // validate email is in the actual format of an email address.
        if (!validateEmail(regData.getEmail())) {
            return RegistrationResponseModel.INVALID_EMAIL;
        }

        // check if username or email are in use already.
        UserModel searchedUser = findByEmail(regData.getEmail());
        if (searchedUser != null)
            return RegistrationResponseModel.EMAIL_IN_USE;

        searchedUser = findByUsername(regData.getUsername());
        if (searchedUser != null)
            return RegistrationResponseModel.USERNAME_IN_USE;

        UserModel user = new UserModel();
        user.setFirstName(regData.getFirstName());
        user.setLastName(regData.getLastName());
        user.setAddress(regData.getAddress());
        user.setCity(regData.getCity());
        user.setState(regData.getState());
        user.setZipCode(regData.getZipCode());
        user.setUsername(regData.getUsername());
        user.setEmail(regData.getEmail());
        user.setPassword(regData.getPassword());
        user.setStudent(true);

        UserModel createdUser = insertUnhashedUser(user);
        if (createdUser == null)
            return RegistrationResponseModel.UNEXPECTED_ERROR;

        return RegistrationResponseModel.SUCCESS;
    }



    public void updateUser(UserModel user) {
        _userRepository.updateUser(user);
    }

    public UserModel findById(String id) {
        return _userRepository.findById(id);
    }

    public UserModel findByUsername(String username) {
        return _userRepository.findByUsername(username);
    }

    public UserModel findByEmail(String email) {
        return _userRepository.findByEmail(email);
    }

    public void deleteUserById(String id)
    {
        _userRepository.deleteUserById(id);
    }
}