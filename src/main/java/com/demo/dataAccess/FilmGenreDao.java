package com.demo.dataAccess;

import com.demo.entities.FilmGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface FilmGenreDao extends JpaRepository<FilmGenre, Long> {
    @Transactional
    void deleteFilmGenreByFilm_FilmId(Long id);
}
