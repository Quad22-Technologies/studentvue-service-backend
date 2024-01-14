package com.service.studentvue.services;

import com.service.studentvue.models.ClassGradeModel;
import com.service.studentvue.models.UserModel;
import com.service.studentvue.repositories.ClassGradeRepository;
import com.service.studentvue.repositories.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClassGradeService {
    @Resource
    ClassGradeRepository _classGradeRepository;

    public List<ClassGradeModel> findAll() {
        return _classGradeRepository.findAll();
    }

    public ClassGradeModel insertClassGrade(ClassGradeModel grade) {
        UUID uuid = UUID.randomUUID();
        grade.setId(uuid.toString());
        return _classGradeRepository.insertClassGrade(grade);
    }

    public void updateClassGrade(ClassGradeModel grade) {
        _classGradeRepository.updateClassGrade(grade);
    }

    public ClassGradeModel findById(String id) {
        return _classGradeRepository.findById(id);
    }

    public List<ClassGradeModel> findByUserId(String id) {
        return _classGradeRepository.findByUserId(id);
    }

    public void deleteClassGradeById(String id)
    {
        _classGradeRepository.deleteClassGradeById(id);
    }
}