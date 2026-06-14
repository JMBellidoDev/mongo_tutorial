package spring.tutorial.mongo.application.port.in;

import spring.tutorial.mongo.domain.model.Order;

import java.util.List;

public interface GetAllOrdersPort {
    List<Order> apply();
}
