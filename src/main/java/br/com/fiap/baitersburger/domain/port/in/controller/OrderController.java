package br.com.fiap.baitersburger.domain.port.in.controller;

import br.com.fiap.baitersburger.interfaceadapters.dto.UpdateOrderStatusDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.request.OrderRequestDTO;
import br.com.fiap.baitersburger.interfaceadapters.dto.response.OrderResponseDTO;
import br.com.fiap.baitersburger.domain.enums.OrderStatus;

import java.util.List;

public interface OrderController {
    void insert(OrderRequestDTO orderRequestDTO);
    List<OrderResponseDTO> findByStatus( OrderStatus status);
    void updateOrderStatus( String orderId, UpdateOrderStatusDTO updateOrderStatusDTO);
}
