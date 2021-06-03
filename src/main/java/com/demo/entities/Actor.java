package com.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "actors")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "films"})
//döngüye girip json parse error vermesin diye.
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "actor")
    @JsonIgnore
    private List<Film> films;
    //sanırım buna gerek yok şuan.

    @OneToMany(mappedBy = "actor")
    @JsonIgnore
    private List<FilmActor> filmActors;
}
