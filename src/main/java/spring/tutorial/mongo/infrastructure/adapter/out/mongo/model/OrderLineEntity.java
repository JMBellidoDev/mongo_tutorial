package spring.tutorial.mongo.infrastructure.adapter.out.mongo.model;

import lombok.Getter;
import lombok.Setter;
import spring.tutorial.mongo.domain.valueobject.Product;

@Getter
@Setter
public class OrderLineEntity {
    private Product product;
    private Integer quantity;
    private Double discount;
}
