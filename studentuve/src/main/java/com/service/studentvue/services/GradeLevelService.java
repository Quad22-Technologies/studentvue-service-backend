package com.service.studentvue.services;

import com.service.studentvue.models.GradeLevelModel;
import com.service.studentvue.repositories.GradeLevelRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GradeLevelService {
    @Resource
    GradeLevelRepository _gradeLevelDao;

    public List<GradeLevelModel> findAll() {
        return _gradeLevelDao.findAll();
    }

    public void insertGradeLevel(GradeLevelModel grade) {
        UUID uuid = UUID.randomUUID();  // create random UUID
        grade.setId(uuid.toString());
        _gradeLevelDao.insertGradeLevel(grade);
    }

    public void updateGradeLevel(GradeLevelModel grade) {
        _gradeLevelDao.updateGradeLevel(grade);
    }

    public GradeLevelModel findById(String id) {
        return _gradeLevelDao.findById(id);
    }
}
