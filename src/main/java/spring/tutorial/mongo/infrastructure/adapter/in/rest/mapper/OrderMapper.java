package spring.tutorial.mongo.infrastructure.adapter.in.rest.mapper;

import model.*;
import org.jspecify.annotations.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import spring.tutorial.mongo.application.command.CreateOrderCommand;
import spring.tutorial.mongo.domain.model.Order;
import spring.tutorial.mongo.domain.valueobject.Customer;
import spring.tutorial.mongo.domain.valueobject.OrderLine;
import spring.tutorial.mongo.domain.valueobject.Product;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    CreateOrderCommand convert(@NonNull CreateOrderRequestDto createOrderRequest);

    Customer convert(CustomerDto customerDto);

    Product convert(ProductDto productDto);

    OrderLine convert(OrderLineDto orderLineDto);

    @Mapping(source = ".", target = "totalPrice", qualifiedByName = "calculateTotalPrice")
    @Mapping(source = "createdDate", target = "orderDate")
    CreateOrderResponseDto convert(@NonNull Order order);

    CustomerDto convert(Customer customer);

    ProductDto convert(Product product);

    OrderLineDto convert(OrderLine orderLine);

    @Named("calculateTotalPrice")
    default Double calculateTotalPrice(Order order) {
        return order.getTotalPrice();
    }

    default GetOrdersResponseDto convert(@NonNull List<Order> orders) {
        return new GetOrdersResponseDto()
                .orders(orders
                        .stream()
                        .map(this::convertFromList)
                        .toList());

    }

    @Mapping(source = ".", target = "totalPrice", qualifiedByName = "calculateTotalPrice")
    @Mapping(source = "createdDate", target = "orderDate")
    OrderDto convertFromList(Order order);

    default OffsetDateTime convertDate(LocalDateTime createdAt) {
        return createdAt != null ? createdAt.atOffset(ZoneOffset.UTC) : null;
    }

    @Mapping(source = ".", target = "totalPrice", qualifiedByName = "calculateTotalPrice")
    @Mapping(source = "createdDate", target = "orderDate")
    OrderResponseDto convertById(Order order);
}
