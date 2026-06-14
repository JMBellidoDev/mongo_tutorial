package spring.tutorial.mongo.infrastructure.adapter.in.rest;

import api.OrdersApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.CreateOrderRequestDto;
import model.CreateOrderResponseDto;
import model.GetOrdersResponseDto;
import model.OrderResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import spring.tutorial.mongo.application.command.CreateOrderCommand;
import spring.tutorial.mongo.application.port.in.CreateOrderPort;
import spring.tutorial.mongo.application.port.in.GetAllOrdersPort;
import spring.tutorial.mongo.domain.model.Order;
import spring.tutorial.mongo.infrastructure.adapter.in.rest.mapper.OrderMapper;

import java.util.List;


@RequiredArgsConstructor
@RestController
@Slf4j
public class OrdersController implements OrdersApi {

    private final OrderMapper orderMapper;

    private final CreateOrderPort createOrderPort;
    private final GetAllOrdersPort getAllOrdersPort;

    @Override
    public ResponseEntity<CreateOrderResponseDto> createOrder(CreateOrderRequestDto createOrderRequest) {
        CreateOrderCommand createOrderCommand = orderMapper.convert(createOrderRequest);
        Order createdOrder = createOrderPort.apply(createOrderCommand);
        CreateOrderResponseDto createOrderResponseDto = orderMapper.convert(createdOrder);

        return ResponseEntity.ok(createOrderResponseDto);
    }

    @Override
    public ResponseEntity<GetOrdersResponseDto> getOrders() {
        log.info("entrando");
        List<Order> orders = getAllOrdersPort.apply();
        GetOrdersResponseDto getOrdersResponseDto = orderMapper.convert(orders);

        return ResponseEntity.ok(getOrdersResponseDto);
    }

    @Override
    public ResponseEntity<OrderResponseDto> getUserById(String id) {
        return OrdersApi.super.getUserById(id);
    }
}
