package com.github.joostvdg.controller;

import com.github.joostvdg.model.Greeting;
import com.github.joostvdg.repository.GreetingRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

@Controller("/greeting")
public class GreetingController {

    @Inject
    GreetingRepository greetingRepository;

    @Get(uri="/", produces= MediaType.TEXT_PLAIN)
    public String index() {
        return "Example Response 21";
    }

    @Get(uri = "/{id}", produces = "application/json")
    public HttpResponse<Greeting> getGreetingById(Long id) {
        var greeting = greetingRepository.findById(id).orElse(null);
        return HttpResponse.ok(greeting);
    }

    @Post
    public HttpResponse<Greeting> save(@Body Greeting greeting) {
        var newGreeting = new Greeting(greeting.getMessage(), greeting.getSender());
        newGreeting = greetingRepository.save(newGreeting);
        return HttpResponse.created(newGreeting);
    }
}
