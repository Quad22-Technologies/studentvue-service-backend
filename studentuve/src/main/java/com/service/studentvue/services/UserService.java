package com.service.studentvue.services;

import com.service.studentvue.models.UserModel;
import com.service.studentvue.repositories.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Resource
    UserRepository _userRepository;

    public List<UserModel> findAll() {
        return _userRepository.findAll();
    }

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
//        user.setSalt(salt);

        return insertHashedUser(user);
    }

    // note: we do not just have a "insertUser" method because we want someone to
    //  think about what kind of info they are inserting.

    public void updateUser(UserModel user) {
        _userRepository.updateUser(user);
    }

    public UserModel findById(String id) {
        return _userRepository.findById(id);
    }

    public void deleteUserById(String id)
    {
        _userRepository.deleteUserById(id);
    }
}