package com.github.joostvdg.repository;

import com.github.joostvdg.model.Greeting;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface GreetingRepository extends CrudRepository<Greeting, Long> {

}
