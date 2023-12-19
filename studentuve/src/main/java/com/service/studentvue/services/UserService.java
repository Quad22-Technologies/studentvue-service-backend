package com.service.studentvue.services;

import com.service.studentvue.models.FamilyNameModel;
import com.service.studentvue.models.UserModel;
import com.service.studentvue.repositories.FamilyNameRepository;
import com.service.studentvue.repositories.UserInfoRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Resource
    UserInfoRepository _userDao;

    public List<UserModel> findAll() {
        return _userDao.findAll();
    }

    public void insertUser(UserModel user) {
        UUID uuid = UUID.randomUUID();  // create random UUID
        user.setId(uuid.toString());
        _userDao.insertUser(user);
    }

    public void updateUser(UserModel user) {
        _userDao.updateUser(user);
    }
    public void deleteUserByID(String id) {
        _userDao.deleteUsersById(id);
    }

    public UserModel findById(String id) {
        return _userDao.findById(id);
    }
}
