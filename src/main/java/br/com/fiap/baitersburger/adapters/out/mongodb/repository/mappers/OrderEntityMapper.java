package br.com.fiap.baitersburger.adapters.out.mongodb.repository.mappers;

import br.com.fiap.baitersburger.adapters.out.mongodb.repository.entity.OrderEntity;
import br.com.fiap.baitersburger.core.domain.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderEntityMapper {
    OrderEntity toOrderEntity(Order order);

    Order toOrder(OrderEntity orderEntity);
}
