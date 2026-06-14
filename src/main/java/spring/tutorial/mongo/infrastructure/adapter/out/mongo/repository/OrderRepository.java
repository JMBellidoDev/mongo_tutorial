package spring.tutorial.mongo.infrastructure.adapter.out.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spring.tutorial.mongo.infrastructure.adapter.out.mongo.model.OrderEntity;

@Repository
public interface OrderRepository extends MongoRepository<OrderEntity, String> {
}
