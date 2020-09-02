package com.daivid.learn.learnboot;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/api")
public class DefaultController {
@GetMapping("/monitor")
    public Object monitor() {
        return "alive";
    }
}
