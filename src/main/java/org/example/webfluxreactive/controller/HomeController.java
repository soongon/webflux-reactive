package org.example.webfluxreactive.controller;

import org.example.webfluxreactive.model.Product;
import org.example.webfluxreactive.serivce.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public Mono<String> home() {
        return Mono.just("Hello World - 현찰데이터");
    }

    @GetMapping("/products")
    public Flux<Product> products() {
        return productService.getAllProducts();
    }
}
