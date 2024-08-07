package org.example.webfluxreactive.serivce;

import org.example.webfluxreactive.model.Product;
import org.example.webfluxreactive.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // 전체 상품보기..
    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Mono<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Mono<Product> addProduct(Product product) {
        return productRepository.save(product);
    }

    public Mono<Product> modifyProduct(Product product) {
        return productRepository
                .findById(product.getId())  // Mono<Product>
                .flatMap(p -> {
                    p.setName(product.getName());
                    p.setPrice(product.getPrice());
                    p.setLikes(product.getLikes());
                    return productRepository.save(p);
                });
    }
}
