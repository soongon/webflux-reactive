package org.example.webfluxreactive.repository;

import org.example.webfluxreactive.model.Product;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class ProductRepository {

    public Flux<Product> selectAllProduct() {
        // 실제 DB에 접속해서 데이터를 가져온다.
        // DB에서 가져온 상품목록을 Flux<Product> 로 만들어서 반환해준다.
        return Flux.just(
                new Product(1, "Apple", 300, 0),
                new Product(2, "Banana", 500, 5),
                new Product(3, "Melon", 1500, 3)
        );
    }
}
