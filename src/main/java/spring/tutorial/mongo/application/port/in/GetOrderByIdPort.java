package spring.tutorial.mongo.application.port.in;

import spring.tutorial.mongo.domain.model.Order;

public interface GetOrderByIdPort {
    Order apply(String id);
}
