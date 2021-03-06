package com.demo.service.abstracts;

import com.demo.core.results.DataResult;
import com.demo.core.results.Result;
import com.demo.entities.Film;
import com.demo.entities.dtos.FilmDto;

import java.util.List;

public interface FilmService {

    Result add(FilmDto filmDto);

    Result deleteByFilmName(String name);

    Result updateByFilmName(String name,FilmDto filmDto);

    DataResult<List<FilmDto>> getAll();

    DataResult<FilmDto> findByName(String name);

    DataResult<List<FilmDto>> findByActorName(String name);

    DataResult<List<FilmDto>> findByGenreName(String name);

}
