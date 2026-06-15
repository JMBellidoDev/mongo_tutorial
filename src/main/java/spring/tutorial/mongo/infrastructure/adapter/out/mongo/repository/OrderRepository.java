package spring.tutorial.mongo.infrastructure.adapter.out.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import spring.tutorial.mongo.infrastructure.adapter.out.mongo.model.OrderEntity;

import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<OrderEntity, String> {

    @Query(value = "{ '_id': ?0 }",
            fields = "{ 'file': 1, '_id': 0 }")
    Optional<OrderEntity> findFileById(String id);
}
