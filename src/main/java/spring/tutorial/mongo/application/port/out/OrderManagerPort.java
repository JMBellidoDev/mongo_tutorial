package spring.tutorial.mongo.application.port.out;

import spring.tutorial.mongo.application.command.UploadFileCommand;
import spring.tutorial.mongo.domain.model.Order;
import spring.tutorial.mongo.domain.valueobject.File;

import java.util.List;
import java.util.Optional;

public interface OrderManagerPort {
    Order create(Order order);

    List<Order> findAll();

    Optional<Order> findById(String id);

    void uploadFile(UploadFileCommand uploadFileCommand);

    Optional<File> findFileByOrderId(String orderId);
}
