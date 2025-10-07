package br.com.fiap.baitersburger.infrastructure.persistence.mapper;

import br.com.fiap.baitersburger.infrastructure.persistence.entity.OrderEntity;
import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.infrastructure.persistence.entity.OrderMySqlEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderEntityMapper {
    OrderEntity toOrderEntity(Order order);
    Order toOrder(OrderEntity orderEntity);

    OrderMySqlEntity toOrderMySqlEntity(Order order);
    Order toOrder(OrderMySqlEntity orderMySqlEntity);


}
