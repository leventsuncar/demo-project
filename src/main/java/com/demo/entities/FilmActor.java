package com.demo.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "films_actor")
public class FilmActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "films_film_id", referencedColumnName = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "actor_actor_id", referencedColumnName = "actor_id")
    private Actor actor;
}
