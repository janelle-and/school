package com.example.HelloWorld.Controller;

import com.example.HelloWorld.model.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public Message HelloWorld(){
        return new Message("Hello World!");
    }
}
