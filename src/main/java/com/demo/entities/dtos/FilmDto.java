package com.demo.entities.dtos;

import com.demo.entities.Actor;
import com.demo.entities.Genre;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class FilmDto {
    private String name;
    private int releaseYear;
    private String media;
    private String language;
    private String description;
    private List<String> actorNames;
    private List<String> genreGenreNames;
}
