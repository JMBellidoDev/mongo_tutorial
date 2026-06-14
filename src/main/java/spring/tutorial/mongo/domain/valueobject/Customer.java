package spring.tutorial.mongo.domain.valueobject;

import lombok.Data;

@Data
public class Customer {
    private String name;
    private String surname1;
    private String surname2;
    private String postalCode;
}
