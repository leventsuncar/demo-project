package com.demo.dataAccess;

import com.demo.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorDao extends JpaRepository<Actor, Long> {
Actor findByName(String name);
}
