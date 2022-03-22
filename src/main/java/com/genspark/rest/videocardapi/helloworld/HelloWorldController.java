package com.genspark.rest.videocardapi.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;
    @RequestMapping(method= RequestMethod.GET, path="/hello-world")
    public String helloWord() {
        return "Hello World";
    }

    @GetMapping(path="/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name ));
    }

}
