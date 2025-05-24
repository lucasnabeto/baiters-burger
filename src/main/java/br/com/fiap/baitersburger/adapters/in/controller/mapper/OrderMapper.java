package br.com.fiap.baitersburger.adapters.in.controller.mapper;

import br.com.fiap.baitersburger.adapters.in.controller.dto.order.OrderRequestDTO;
import br.com.fiap.baitersburger.adapters.in.controller.dto.order.OrderResponseDTO;
import br.com.fiap.baitersburger.core.domain.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, CustomerMapper.class})
public interface OrderMapper {
    Order toOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO toOrderResponseDTO(Order order);
}
