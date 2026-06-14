package spring.tutorial.mongo.application.port.in.mapper;

import org.jspecify.annotations.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.core.convert.converter.Converter;
import spring.tutorial.mongo.application.command.CreateOrderCommand;
import spring.tutorial.mongo.domain.model.Order;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreateOrderCommandMapper extends Converter<CreateOrderCommand, Order> {

    @Override
    @Mapping(target = "createdDate", expression = "java(java.time.LocalDateTime.now())")
    Order convert(@NonNull CreateOrderCommand createOrderCommand);
}
