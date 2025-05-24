package br.com.fiap.baitersburger.adapters.out.mongodb.repository;

import br.com.fiap.baitersburger.adapters.out.mongodb.repository.entity.OrderEntity;
import br.com.fiap.baitersburger.core.domain.enums.OrderStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<OrderEntity,String> {
    List<OrderEntity> findByStatus(OrderStatus status);
}
