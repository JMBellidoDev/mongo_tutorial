package spring.tutorial.mongo.infrastructure.adapter.out.mongo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "order")
@Getter
@Setter
public class OrderEntity {
    @Id
    private String id;
    private CustomerEntity customer;
    private List<OrderLineEntity> orderLines;
    private LocalDateTime createdAt;
}
