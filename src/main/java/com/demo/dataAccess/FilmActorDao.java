package com.demo.dataAccess;

import com.demo.entities.FilmActor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface FilmActorDao extends JpaRepository<FilmActor, Long> {
    @Transactional
    void deleteFilmActorByFilm_FilmId(Long id);

}
