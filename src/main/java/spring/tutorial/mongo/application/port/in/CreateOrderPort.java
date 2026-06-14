package spring.tutorial.mongo.application.port.in;

import spring.tutorial.mongo.application.command.CreateOrderCommand;
import spring.tutorial.mongo.domain.model.Order;

public interface CreateOrderPort {
    Order apply(CreateOrderCommand createOrderCommand);
}
