package codegym.repository;

import codegym.entity.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, String> {
    List<Subject> findByTeacherContains(String teacher);

    @Query("select s from Subject s where s.teacher like :teacher")
    List<Subject> querySubjectByTeacherName(String teacher);
}
