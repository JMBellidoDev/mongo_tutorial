package spring.tutorial.mongo.application.usecase;

import lombok.RequiredArgsConstructor;
import spring.tutorial.mongo.application.command.CreateOrderCommand;
import spring.tutorial.mongo.application.exception.UnexpectedError;
import spring.tutorial.mongo.application.port.in.CreateOrderPort;
import spring.tutorial.mongo.application.port.in.mapper.CreateOrderCommandMapper;
import spring.tutorial.mongo.application.port.out.OrderManagerPort;
import spring.tutorial.mongo.common.UseCase;
import spring.tutorial.mongo.domain.model.Order;

@UseCase
@RequiredArgsConstructor
public class CreateOrderUseCase implements CreateOrderPort {

    private final CreateOrderCommandMapper mapper;

    private final OrderManagerPort orderManagerPort;

    @Override
    public Order apply(CreateOrderCommand createOrderCommand) {
        Order order = mapper.convert(createOrderCommand);
        if (order == null) {
            throw new UnexpectedError("Order conversion failed");
        }

        order.gatherRepeatedProducts();
        return orderManagerPort.create(order);
    }
}
