package spring.tutorial.mongo.infrastructure.adapter.out.mongo;

import lombok.RequiredArgsConstructor;
import spring.tutorial.mongo.application.port.out.OrderManagerPort;
import spring.tutorial.mongo.common.Adapter;
import spring.tutorial.mongo.domain.model.Order;
import spring.tutorial.mongo.infrastructure.adapter.out.mongo.mapper.OrderEntityMapper;
import spring.tutorial.mongo.infrastructure.adapter.out.mongo.model.OrderEntity;
import spring.tutorial.mongo.infrastructure.adapter.out.mongo.repository.OrderRepository;

import java.util.List;

@Adapter
@RequiredArgsConstructor
public class OrderManagerAdapter implements OrderManagerPort {

    private final OrderEntityMapper orderEntityMapper;

    private final OrderRepository orderRepository;

    @Override
    public Order create(Order order) {
        OrderEntity orderEntity = orderEntityMapper.convert(order);
        OrderEntity savedOrder = orderRepository.insert(orderEntity);

        return orderEntityMapper.convert(savedOrder);
    }

    @Override
    public List<Order> findAll() {
        List<OrderEntity> orders = orderRepository.findAll();
        return orderEntityMapper.convert(orders);
    }
}
