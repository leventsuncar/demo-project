package com.demo.service.abstracts;

import com.demo.core.results.DataResult;
import com.demo.core.results.Result;
import com.demo.entities.Film;
import com.demo.entities.dtos.FilmDto;

import java.util.List;

public interface FilmService {

    Result add(FilmDto filmDto);

    Result deleteByFilmName(String name);

    Result updateByFilmName(String name);

    DataResult<List<FilmDto>> getAll();

    DataResult<Film> findByName(String name);

    DataResult<List<Film>> findByActorName(String name);

    DataResult<List<Film>> findByGenreName(String name);

}
