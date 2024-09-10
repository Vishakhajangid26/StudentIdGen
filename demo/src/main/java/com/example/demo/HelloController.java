package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students")
public class HelloController {

    @Autowired
    private AnshuRepo anshuRepo;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/hello/{name}")
    public String greetUser(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
    @PostMapping("/anshu")
    public String getUser(@RequestBody Anshu anshu){
        System.out.println(anshu.getName());
        return "{" + anshu.getName() + ": is the pro}";
    }
}
