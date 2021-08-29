package com.github.joostvdg;

import io.micronaut.http.annotation.*;

@Controller("/mnautDemo")
public class MnautDemoController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}