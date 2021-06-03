package com.demo.service.concretes;

import com.demo.core.results.DataResult;
import com.demo.core.results.Result;
import com.demo.core.results.SuccessDataResult;
import com.demo.core.results.SuccessResult;
import com.demo.dataAccess.ActorDao;
import com.demo.dataAccess.FilmDao;
import com.demo.dataAccess.GenreDao;
import com.demo.entities.Actor;
import com.demo.entities.Film;
import com.demo.entities.Genre;
import com.demo.entities.dtos.FilmDto;
import com.demo.service.abstracts.FilmService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmManager implements FilmService {

    private FilmDao filmDao;
    private ModelMapper modelMapper;
    private ActorDao actorDao;
    private GenreDao genreDao;


    @Autowired
    public FilmManager(FilmDao filmDao, ModelMapper modelMapper, ActorDao actorDao, GenreDao genreDao) {
        this.filmDao = filmDao;
        this.modelMapper = modelMapper;
        this.actorDao = actorDao;
        this.genreDao = genreDao;
    }

    @Override
    public Result add(FilmDto filmDto) {
        Film film = modelMapper.map(filmDto, Film.class);
        List<Actor> actorList = new ArrayList<Actor>();
        for (String actor : filmDto.getActorNames()) {
            actorList.add(actorDao.findByName(actor));
        }
        film.setActor(actorList);
        List<Genre> genreList = new ArrayList<Genre>();
        for (String genre : filmDto.getGenreNames()) {
            genreList.add(genreDao.findByName(genre));
        }
        film.setGenre(genreList);
        filmDao.save(film);
        return new SuccessResult("Film eklendi");
    }

    @Override
    public Result deleteByFilmName(String name) {

        filmDao.delete(filmDao.findByFilmName(name));

        return new SuccessResult("Film silindi");
    }

    @Override
    public Result updateByFilmName(String name) {

        //yapılacak

        return null;
    }

    @Override
    public DataResult<List<FilmDto>> getAll() {
        List<Film> filmList = filmDao.findAll();
        return new SuccessDataResult<List<FilmDto>>(map(filmList));
    }

    @Override
    public DataResult<FilmDto> findByName(String name) {
    Film film = filmDao.findByFilmName(name);

    return new SuccessDataResult<FilmDto>(modelMapper.map(film,FilmDto.class));
    }

    @Override
    public DataResult<List<FilmDto>> findByActorName(String actorName) {
        List<Film> filmList = filmDao.findAllByActor_Name(actorName);
        return new SuccessDataResult<List<FilmDto>>(map(filmList));
    }

    @Override
    public DataResult<List<FilmDto>> findByGenreName(String genreName) {
        List<Film> filmList = filmDao.findAllByGenre_Name(genreName);

        return new SuccessDataResult<List<FilmDto>>(map(filmList));


    }

    public List<FilmDto> map(List<Film> filmList) {
        List<FilmDto> filmDtoList = new ArrayList<FilmDto>();
        for (Film film : filmList) {

            List<String> actorNames = new ArrayList<String>();
            List<String> genreNames = new ArrayList<String>();

            for (Actor actor : film.getActor()) {
                actorNames.add(actor.getName());
            }
            for (Genre genre : film.getGenre()) {
                genreNames.add(genre.getName());
            }
            FilmDto filmDto = modelMapper.map(film, FilmDto.class);
            filmDto.setActorNames(actorNames);
            filmDto.setGenreNames(genreNames);
            filmDtoList.add(filmDto);
        }
        return filmDtoList;
    }
}
