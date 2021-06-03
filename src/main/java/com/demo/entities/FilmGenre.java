package com.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "films_genre")
public class FilmGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "films_film_id", referencedColumnName = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "genre_genre_id", referencedColumnName = "genre_id")
    private Genre genre;
}
