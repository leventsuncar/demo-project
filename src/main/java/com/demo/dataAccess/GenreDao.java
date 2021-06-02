package com.demo.dataAccess;

import com.demo.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDao extends JpaRepository<Genre, Long> {
Genre findByName(String name);
}
