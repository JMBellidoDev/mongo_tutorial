package spring.tutorial.mongo.application.command;

import lombok.Data;
import spring.tutorial.mongo.domain.valueobject.Customer;
import spring.tutorial.mongo.domain.valueobject.OrderLine;

import java.util.List;

@Data
public class CreateOrderCommand {
    private Customer customer;
    private List<OrderLine> orderLines;
}
