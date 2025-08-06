package br.com.fiap.baitersburger.infrastructure.persistence.repository;

import br.com.fiap.baitersburger.infrastructure.persistence.entity.OrderEntity;
import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderMongoRepository extends MongoRepository<OrderEntity,String> {
    List<OrderEntity> findByStatus(OrderStatus status);

    @Aggregation(pipeline = {
            "{ $match: { status: { $in: ['READY', 'PREPARING', 'RECEIVED'] } } }",
            "{ $addFields: { statusOrder: { $switch: { branches: [ " +
                    "{ case: { $eq: [ \"$status\", \"READY\" ] }, then: 0 }, " +
                    "{ case: { $eq: [ \"$status\", \"PREPARING\" ] }, then: 1 }, " +
                    "{ case: { $eq: [ \"$status\", \"RECEIVED\" ] }, then: 2 } " +
                    "] } } } }",
            "{ $sort: { statusOrder: 1, createdAt: 1 } }"
    })
    List<OrderEntity> findByStatuses(List<OrderStatus> statuses);
}
