package com.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "genres")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "films"})
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long genreId;

    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;

    @ManyToMany(mappedBy = "genre")
    @JsonIgnore
    private List<Film> films;
    //sanırım şuan buna gerek yok.

    @OneToMany(mappedBy = "genre")
    @JsonIgnore
    private List<FilmGenre> filmGenres;
}
