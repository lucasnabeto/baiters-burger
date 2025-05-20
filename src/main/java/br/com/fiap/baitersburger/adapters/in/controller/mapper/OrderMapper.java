package br.com.fiap.baitersburger.adapters.in.controller.mapper;

import br.com.fiap.baitersburger.adapters.in.controller.dto.order.OrderRequestDTO;
import br.com.fiap.baitersburger.core.domain.model.Order;

public interface OrderMapper {
    Order toOrder(OrderRequestDTO orderRequestDTO);
}
