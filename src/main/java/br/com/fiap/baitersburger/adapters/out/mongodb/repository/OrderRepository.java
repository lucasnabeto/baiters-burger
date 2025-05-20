package br.com.fiap.baitersburger.adapters.out.mongodb.repository;

import br.com.fiap.baitersburger.adapters.out.mongodb.repository.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity,String> {
}
