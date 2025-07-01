package br.com.fiap.baitersburger.infrastructure.web.mapper;

import br.com.fiap.baitersburger.application.dto.request.OrderRequestDTO;
import br.com.fiap.baitersburger.application.dto.response.OrderResponseDTO;
import br.com.fiap.baitersburger.domain.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, CustomerMapper.class})
public interface OrderMapper {
    Order toOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO toOrderResponseDTO(Order order);
}
