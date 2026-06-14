package spring.tutorial.mongo.infrastructure.adapter.out.mongo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerEntity {
    private String name;
    private String surname1;
    private String surname2;
    private String postalCode;
}
