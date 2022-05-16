package model.service;

import model.bean.StudentClass;

import java.util.List;

public interface ClassService {
    List<StudentClass> findByAll();
}
