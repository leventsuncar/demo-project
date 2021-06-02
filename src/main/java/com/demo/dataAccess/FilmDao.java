package com.demo.dataAccess;

import com.demo.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmDao extends JpaRepository<Film, Long> {

    Film findByFilmName(String name);

    List<Film> findAllByActor_Name(String name);

    List<Film> findAllByGenre_Name(String genreName);
}
