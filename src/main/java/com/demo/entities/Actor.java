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
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actor_id")
    private Long id;

    @Column(name = "name")
    private String name;


    @ManyToMany(mappedBy = "actor")
    @JsonIgnore
    private List<Film> films;
}
