package model.repository;

import model.bean.StudentClass;

import java.util.List;

public interface ClassRepository {
    List<StudentClass> findByAll();

}
