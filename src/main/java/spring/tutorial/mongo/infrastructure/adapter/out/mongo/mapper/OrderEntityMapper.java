package spring.tutorial.mongo.infrastructure.adapter.out.mongo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import spring.tutorial.mongo.domain.model.Order;
import spring.tutorial.mongo.domain.valueobject.Customer;
import spring.tutorial.mongo.domain.valueobject.OrderLine;
import spring.tutorial.mongo.domain.valueobject.Product;
import spring.tutorial.mongo.infrastructure.adapter.out.mongo.model.CustomerEntity;
import spring.tutorial.mongo.infrastructure.adapter.out.mongo.model.OrderEntity;
import spring.tutorial.mongo.infrastructure.adapter.out.mongo.model.OrderLineEntity;
import spring.tutorial.mongo.infrastructure.adapter.out.mongo.model.ProductEntity;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderEntityMapper {

    @Mapping(source = "createdDate", target = "createdAt")
    OrderEntity convert(Order order);

    CustomerEntity convert(Customer customer);

    OrderLineEntity convert(OrderLine orderLine);

    ProductEntity convert(Product product);

    @Mapping(source = "createdAt", target = "createdDate")
    Order convert(OrderEntity orderEntity);

    Customer convert(CustomerEntity customerEntity);

    OrderLine convert(OrderLineEntity orderLineEntity);

    Product convert(ProductEntity productEntity);

    List<Order> convert(List<OrderEntity> orderEntities);
}
