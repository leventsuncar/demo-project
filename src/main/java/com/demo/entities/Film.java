package com.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "name",unique = true)
    @NotBlank(message = "Film ismi boş bırakılamaz")
    @NotNull(message = "Film ismi boş bırakılamaz")
    private String filmName;

    @Column(name = "release_year")
    @NotNull(message = "Yayınlanma yılı boş bırakılamaz")
    private int releaseYear;

    @Column(name = "media",length = 500)
    @NotBlank(message = "Medya boş bırakılamaz")
    @NotNull(message = "Medya boş bırakılamaz")
    private String media;
    //bu fieldda tuttuğum şey resim linki.

    @Column(name = "language")
    private String language;


    @Column(name = "description", length = 750)
    private String description;

    @ManyToMany
    @JoinColumn(name = "actor_id")
    private List<Actor> actor;

    @ManyToMany
    @JoinColumn(name = "genre_id")
    private List<Genre> genre;

    @OneToMany(mappedBy = "film")
    @JsonIgnore
    private List<FilmActor> filmActors;

    @OneToMany(mappedBy = "film")
    @JsonIgnore
    private List<FilmGenre> filmGenres;
}

