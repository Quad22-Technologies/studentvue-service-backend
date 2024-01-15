package com.service.studentvue.services;


import com.service.studentvue.models.ClassNameModel;
import com.service.studentvue.repositories.ClassNameRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClassNameService {
    @Resource
    ClassNameRepository _classNameRepository;

    public List<ClassNameModel> findAll() {
        return _classNameRepository.findAll();
    }

    public ClassNameModel insertClassName(ClassNameModel classname) {
        UUID uuid = UUID.randomUUID();  // create random UUID
        classname.setId(uuid.toString());
        _classNameRepository.insertClassName(classname);
        return classname; // TODO fetch from db instead
    }

    public void updateClassName(ClassNameModel classname) {
        _classNameRepository.updateClassName(classname);
    }

    public ClassNameModel findById(String id) {
        return _classNameRepository.findById(id);
    }

    public List<ClassNameModel> getAvailableClasses(String id) {
        return _classNameRepository.getAvailableClasses(id);
    }

    public List<ClassNameModel> getRegisteredClasses(String id) {
        return _classNameRepository.getRegisteredClasses(id);
    }

    public void deleteClassNameById(String id)
    {
        _classNameRepository.deleteClassNameById(id);
    }
}