package com.demo.entities.dtos;

import lombok.Data;

import java.util.List;

@Data
public class FilmDto {
    private String name;
    private int releaseYear;
    private String media;
    private String language;
    private String description;
    private List<String> actorNames;
    private List<String> genreNames;

    //Dto olmadan olmaz
}
