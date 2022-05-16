package codegym.repository;

import codegym.entity.Music;

import java.util.List;

public interface MusicRepository {

    List<Music> findAll();

    void save(Music music);

    public List<Music> findById(int id);

    List<Music> findByName(String name);

    void update(Music music);

    void remove(int id);

}
