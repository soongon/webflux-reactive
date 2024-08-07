package org.example.webfluxreactive.controller;

import org.example.webfluxreactive.model.Product;
import org.example.webfluxreactive.serivce.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/products/{id}")
    public Mono<Product> getProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public Mono<Product> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/products")
    public Mono<Product> updateProduct(@RequestBody Product product) {
        return productService.modifyProduct(product);
    }

}
