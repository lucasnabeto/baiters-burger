package br.com.fiap.baitersburger.application.usecase.order;

import br.com.fiap.baitersburger.domain.enums.OrderStatus;

public interface UpdateOrderStatusUseCase {
    void updateOrderStatus(String orderId, OrderStatus status);
}
