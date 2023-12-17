package com.service.studentvue.services;

import com.service.studentvue.models.StudentModel;
import com.service.studentvue.repositories.StudentInfoRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    @Resource
    StudentInfoRepository _studentDao;

    public List<StudentModel> findAll() {
        return _studentDao.findAll();
    }

    public void insertStudent(StudentModel student) {
        UUID uuid = UUID.randomUUID();  // create random UUID
        student.setId(uuid.toString());
        _studentDao.insertStudent(student);
    }

    public void updateStudent(StudentModel student) {
        _studentDao.updateStudent(student);
    }

    public StudentModel findById(String id) {
        return _studentDao.findById(id);
    }

    public StudentModel findByUserId(String id) {
        return _studentDao.findByUserId(id);
    }

    public void deleteStudentByID(String id) {
        _studentDao.deleteStudentById(id);
    }
}
