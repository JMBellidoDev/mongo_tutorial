package spring.tutorial.mongo.application.port.out;

import spring.tutorial.mongo.domain.model.Order;

import java.util.List;

public interface OrderManagerPort {
    Order create(Order order);

    List<Order> findAll();
}
