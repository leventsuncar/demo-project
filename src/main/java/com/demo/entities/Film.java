package com.demo.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "name")
    @NotBlank(message = "Film ismi boş bırakılamaz")
    @NotNull(message = "Film ismi boş bırakılamaz")
    private String filmName;

    @Column(name = "release_year")
    @NotNull(message = "Yayınlanma yılı boş bırakılamaz")
    private int releaseYear;

    @Column(name = "media")
    @NotBlank(message = "Medya boş bırakılamaz")
    @NotNull(message = "Medya boş bırakılamaz")
    private String media;

    @Column(name = "language") //bu enum olmalı galiba
    private String language;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinColumn(name = "actor_id")
    private List<Actor> actor;

    @ManyToMany
    @JoinColumn(name = "genre_id")
    private List<Genre> genre;


}

