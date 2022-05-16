package model.service.impl;

import model.bean.StudentClass;
import model.repository.ClassRepository;
import model.repository.impl.ClassRepositoryImpl;
import model.service.ClassService;

import java.util.List;

public class ClassServiceImpl implements ClassService {
    ClassRepository classRepository = new ClassRepositoryImpl();
    @Override
    public List<StudentClass> findByAll() {
        return classRepository.findByAll();
    }
}
