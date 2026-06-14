package spring.tutorial.mongo.application.usecase;

import lombok.RequiredArgsConstructor;
import spring.tutorial.mongo.application.exception.NotFoundError;
import spring.tutorial.mongo.application.port.in.GetOrderByIdPort;
import spring.tutorial.mongo.application.port.out.OrderManagerPort;
import spring.tutorial.mongo.common.UseCase;
import spring.tutorial.mongo.domain.model.Order;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class GetOrderByIdUseCase implements GetOrderByIdPort {

    private final OrderManagerPort orderManagerPort;

    @Override
    public Order apply(String id) {
        Optional<Order> orderOpt = orderManagerPort.findById(id);
        return orderOpt.orElseThrow(() -> new NotFoundError("Order"));
    }
}
