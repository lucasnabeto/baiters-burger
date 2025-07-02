package br.com.fiap.baitersburger.domain.port.in.usecase.order;

import br.com.fiap.baitersburger.domain.enums.OrderStatus;

public interface UpdateOrderStatusUseCase {
    void updateOrderStatus(String orderId, OrderStatus status);
}
