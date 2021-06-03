package com.demo.service.concretes;

import com.demo.core.results.DataResult;
import com.demo.core.results.Result;
import com.demo.core.results.SuccessDataResult;
import com.demo.core.results.SuccessResult;
import com.demo.dataAccess.*;
import com.demo.entities.Actor;
import com.demo.entities.Film;
import com.demo.entities.Genre;
import com.demo.entities.dtos.FilmDto;
import com.demo.service.abstracts.FilmService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilmManager implements FilmService {

    private FilmDao filmDao;
    private ModelMapper modelMapper;
    private ActorDao actorDao;
    private GenreDao genreDao;
    private FilmActorDao filmActorDao;
    private FilmGenreDao filmGenreDao;


    @Autowired
    public FilmManager(FilmDao filmDao, ModelMapper modelMapper, ActorDao actorDao, GenreDao genreDao, FilmActorDao filmActorDao, FilmGenreDao filmGenreDao) {
        this.filmDao = filmDao;
        this.modelMapper = modelMapper;
        this.actorDao = actorDao;
        this.genreDao = genreDao;
        this.filmActorDao = filmActorDao;
        this.filmGenreDao = filmGenreDao;
    }

    @Override
    public Result add(FilmDto filmDto) {
        filmDao.save(map(filmDto));
        return new SuccessResult("Film eklendi");
    }

    @Override
    public Result deleteByFilmName(String name) {
        Film film = filmDao.findByFilmName(name);
        filmGenreDao.deleteFilmGenreByFilm_FilmId(film.getFilmId());
        filmActorDao.deleteFilmActorByFilm_FilmId(film.getFilmId());
        filmDao.deleteFilmByFilmName(name);

        return new SuccessResult("Film silindi");
    }

    @Override
    @Transactional
    public Result updateByFilmName(String name, FilmDto filmDto) {
        Film film1 = filmDao.findByFilmName(name);
        Film film2 = map(filmDto);
        film1.setFilmName(film2.getFilmName());
        film1.setActor(film2.getActor());
        film1.setGenre(film2.getGenre());
        film1.setMedia(film2.getMedia());
        film1.setReleaseYear(film2.getReleaseYear());
        film1.setLanguage(film2.getLanguage());
        film1.setDescription(film2.getDescription());
        filmDao.save(film1);
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
        FilmDto filmDto = modelMapper.map(film, FilmDto.class);
        List<String> actorList = new ArrayList<String>();
        for (Actor actor : film.getActor()) {
            actorList.add(actor.getName());
        }
        filmDto.setActorNames(actorList);
        //film içindeki aktör listesinin sadece string adlarını alıp filmdto içindeki string listesine ekliyorum.
        //bunu yapmazsam aktor çıktısı null geliyor.
        List<String> genreList = new ArrayList<String>();
        for (Genre genre : film.getGenre()) {
            genreList.add(genre.getName());
        }
        filmDto.setGenreNames(genreList);
        //aynı şey burada da geçerli

        return new SuccessDataResult<FilmDto>(filmDto);
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
        //kalabalık olmasın diye bu metodları yazdım
    }

    public Film map(FilmDto filmDto) {
        //metod adları aynı olsa bile parametreleri farklı.
        Film film = modelMapper.map(filmDto, Film.class);
        List<Actor> actorList = new ArrayList<Actor>();
        for (String actor : filmDto.getActorNames()) {
            if (actorDao.findByName(actor) == null) {
                Actor actor1 = new Actor();
                actor1.setName(actor);
                actorDao.save(actor1);
                actorList.add(actor1);
            } else {
                actorList.add(actorDao.findByName(actor));
            }

        }
        film.setActor(actorList);
        List<Genre> genreList = new ArrayList<Genre>();
        for (String genre : filmDto.getGenreNames()) {
            if (genreDao.findByName(genre) == null) {
                Genre genre1 = new Genre();
                genre1.setName(genre);
                genreDao.save(genre1);
                genreList.add(genre1);
            } else {
                genreList.add(genreDao.findByName(genre));
            }
        }
        film.setGenre(genreList);
        return film;
    }
}
