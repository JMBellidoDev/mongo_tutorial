package spring.tutorial.mongo.domain.model;

import lombok.Data;
import spring.tutorial.mongo.domain.valueobject.Customer;
import spring.tutorial.mongo.domain.valueobject.OrderLine;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class Order {
    private String id;
    private Customer customer;
    private List<OrderLine> orderLines;
    private LocalDateTime createdDate;

    public Double getTotalPrice() {
        return orderLines.stream()
                .map(ol -> ol.getQuantity() * ol.getProduct().getPrice() * (1 - ol.getDiscount()))
                .reduce(0.0, Double::sum);
    }

    public void gatherRepeatedProducts() {
        orderLines = orderLines.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.summingInt(OrderLine::getQuantity)
                ))
                .entrySet().stream()
                .map(e -> {
                    OrderLine orderLine = new OrderLine();
                    orderLine.setProduct(e.getKey().getProduct());
                    orderLine.setQuantity(e.getValue());
                    orderLine.setDiscount(e.getKey().getDiscount());
                    return orderLine;
                })
                .toList();

    }
}
