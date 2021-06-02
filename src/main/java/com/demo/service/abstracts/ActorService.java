package com.demo.service.abstracts;

import com.demo.core.results.DataResult;
import com.demo.core.results.Result;
import com.demo.entities.Actor;

import java.util.List;

public interface ActorService {

    Result add(Actor actor);

    Result deleteByActorName(String name);

    Result updateByActorName(String name);

    DataResult<List<Actor>> getAll();

    DataResult<Actor> findByName(String name);
}
