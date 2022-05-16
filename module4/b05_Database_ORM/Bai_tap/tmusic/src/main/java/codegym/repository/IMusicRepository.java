package codegym.repository;

import codegym.entity.Music;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class IMusicRepository implements MusicRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Music> findAll() {
        return entityManager.createQuery("SELECT m from Music m").getResultList();
    }

    @Override
    public void save(Music music) {
        entityManager.persist(music);
    }

    @Override
    public List<Music> findById(int id) {
        List<Music> music = entityManager.createQuery(
                "SELECT m from Music m where m.id = :id")
                .setParameter("id", id)
                .getResultList();
        return music;
    }

    @Override
    public List<Music> findByName(String name) {
        List<Music> music = entityManager.createQuery(
                "SELECT m from Music m where m.name like :name")
                .setParameter("name", "%"+name+"%")
                .getResultList();
        return music;
    }


    @Override
    public void update(Music music) {
        entityManager.merge(music);
    }

    @Override
    public void remove(int id) {
        Music music = entityManager.find(Music.class, id);
        entityManager.remove(music);
    }
}
