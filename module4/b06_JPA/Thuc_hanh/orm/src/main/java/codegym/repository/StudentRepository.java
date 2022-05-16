package codegym.repository;

import codegym.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class StudentRepository {
    @PersistenceContext
    EntityManager entityManager;

    public void createStudent(Student student) {
        entityManager.persist(student);
    }

    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    public List<Student> getList() {
        return entityManager.createQuery("Select s from Student s").getResultList();
    }

    public void updateStudent(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> findStudentByName(String name) {
        List<Student> students = entityManager.createQuery(
                "select s from Student s where s.name like :name")
                .setParameter("name", "%" + name + "%")
                .getResultList();
        return students;
    }

    /*
        numberPage: số trang
        recordOnPage: số record trên mỗi trang
     */
    public List<Student> findStudentByNameWithPaging(String name, int numberPage, int recordOnPage) {
        List<Student> students = entityManager.createQuery(
                        "select s from Student s where s.name like :name")
                .setParameter("name", "%" + name + "%")
                .setFirstResult((numberPage - 1) * recordOnPage)
                .setMaxResults(recordOnPage)
                .getResultList();
        return students;
    }

    public List<Student> findStudentByAddress(String address) {
        List<Student> students = entityManager.createNamedQuery("findByAddress")
                .setParameter("address", "%" + address + "%")
                .getResultList();
        return students;
    }

    public List<Student> findStudentBySubjectName(String subjectName) {
        List<Student> students = entityManager.createQuery(
                        "select s from Student s where s.subject.subjectName like :subjectName")
                .setParameter("subjectName", "%" + subjectName + "%")
                .getResultList();
        return students;
    }
}
