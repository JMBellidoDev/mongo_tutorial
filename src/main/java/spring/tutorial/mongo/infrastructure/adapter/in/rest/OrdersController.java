package spring.tutorial.mongo.infrastructure.adapter.in.rest;

import api.OrdersApi;
import lombok.RequiredArgsConstructor;
import model.CreateOrderRequestDto;
import model.CreateOrderResponseDto;
import model.GetOrdersResponseDto;
import model.OrderResponseDto;
import org.apache.http.HttpStatus;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import spring.tutorial.mongo.application.command.CreateOrderCommand;
import spring.tutorial.mongo.application.command.UploadFileCommand;
import spring.tutorial.mongo.application.port.in.*;
import spring.tutorial.mongo.domain.model.Order;
import spring.tutorial.mongo.domain.valueobject.File;
import spring.tutorial.mongo.infrastructure.adapter.in.rest.mapper.OrderMapper;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class OrdersController implements OrdersApi {

    private final OrderMapper orderMapper;

    private final CreateOrderPort createOrderPort;
    private final GetAllOrdersPort getAllOrdersPort;
    private final GetOrderByIdPort getOrderByIdPort;
    private final UploadFilePort uploadFilePort;
    private final GetFilePort getFilePort;

    @Override
    public ResponseEntity<CreateOrderResponseDto> createOrder(CreateOrderRequestDto createOrderRequest) {
        CreateOrderCommand createOrderCommand = orderMapper.convert(createOrderRequest);
        Order createdOrder = createOrderPort.apply(createOrderCommand);
        CreateOrderResponseDto createOrderResponseDto = orderMapper.convert(createdOrder);

        return ResponseEntity.status(HttpStatus.SC_CREATED).body(createOrderResponseDto);
    }

    @Override
    public ResponseEntity<GetOrdersResponseDto> getOrders() {
        List<Order> orders = getAllOrdersPort.apply();
        GetOrdersResponseDto getOrdersResponseDto = orderMapper.convert(orders);

        return ResponseEntity.ok(getOrdersResponseDto);
    }

    @Override
    public ResponseEntity<OrderResponseDto> getUserById(String id) {
        Order order = getOrderByIdPort.apply(id);
        OrderResponseDto orderResponseDto = orderMapper.convertById(order);

        return ResponseEntity.ok(orderResponseDto);
    }

    @Override
    public ResponseEntity<Void> uploadFile(String id, MultipartFile file) {
        UploadFileCommand uploadFileCommand = new UploadFileCommand();
        uploadFileCommand.setOrderId(id);
        uploadFileCommand.setFile(file);

        uploadFilePort.apply(uploadFileCommand);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Resource> getOrderFile(String id) {
        File file = getFilePort.apply(id);

        ByteArrayResource resource = new ByteArrayResource(file.getContent());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getContentType()))
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        String.format("attachment; filename=\"%s\"", file.getFileName())
                )
                .contentLength(file.getContent().length)
                .body(resource);
    }
}
