package org.example.webfluxreactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HomeController {

    @GetMapping("/")
    public Mono<String> home() {
        return Mono.just("Hello World - 현찰데이터");
    }

    @GetMapping("/products")
    public Flux<String> products() {
        return Flux.just("Apple", "Banana", "Orange", "Grape")
                .filter(s -> s.length() > 2)
                .map(s -> s.substring(0, 2));
                //.map(s -> s.substring(2));
    }
}
