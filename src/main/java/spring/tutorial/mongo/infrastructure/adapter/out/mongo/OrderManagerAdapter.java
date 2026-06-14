package spring.tutorial.mongo.infrastructure.adapter.out.mongo;

import lombok.RequiredArgsConstructor;
import spring.tutorial.mongo.application.command.UploadFileCommand;
import spring.tutorial.mongo.application.exception.NotFoundError;
import spring.tutorial.mongo.application.exception.UnexpectedError;
import spring.tutorial.mongo.application.port.out.OrderManagerPort;
import spring.tutorial.mongo.common.Adapter;
import spring.tutorial.mongo.domain.model.Order;
import spring.tutorial.mongo.infrastructure.adapter.out.mongo.mapper.OrderEntityMapper;
import spring.tutorial.mongo.infrastructure.adapter.out.mongo.model.FileEntity;
import spring.tutorial.mongo.infrastructure.adapter.out.mongo.model.OrderEntity;
import spring.tutorial.mongo.infrastructure.adapter.out.mongo.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Order> findById(String id) {
        Optional<OrderEntity> byId = orderRepository.findById(id);
        return byId.map(orderEntityMapper::convert);
    }

    @Override
    public void uploadFile(UploadFileCommand uploadFileCommand) {
        OrderEntity foundOrder = orderRepository
                .findById(uploadFileCommand.getOrderId())
                .orElseThrow(() -> new NotFoundError("Order"));

        try {
            FileEntity fileEntity = new FileEntity();
            fileEntity.setFileName(uploadFileCommand.getFile().getOriginalFilename());
            fileEntity.setContentType(uploadFileCommand.getFile().getContentType());
            fileEntity.setContent(uploadFileCommand.getFile().getBytes());

            foundOrder.setFile(fileEntity);
            orderRepository.save(foundOrder);
        } catch (Exception e) {
            throw new UnexpectedError(e.getMessage());
        }
    }
}
