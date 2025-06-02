package br.com.fiap.baitersburger.core.application.ports.in.order;

import br.com.fiap.baitersburger.core.domain.enums.OrderStatus;

public interface UpdateOrderStatusInputPort {
    void updateOrderStatus(String orderId, OrderStatus status);
}
