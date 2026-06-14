package spring.tutorial.mongo.application.usecase;

import lombok.RequiredArgsConstructor;
import spring.tutorial.mongo.application.port.in.GetAllOrdersPort;
import spring.tutorial.mongo.application.port.out.OrderManagerPort;
import spring.tutorial.mongo.common.UseCase;
import spring.tutorial.mongo.domain.model.Order;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetAllOrdersUseCase implements GetAllOrdersPort {

    private final OrderManagerPort orderManagerPort;

    @Override
    public List<Order> apply() {
        return orderManagerPort.findAll();
    }
}
