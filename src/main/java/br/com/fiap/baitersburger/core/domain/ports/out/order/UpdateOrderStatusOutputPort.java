package br.com.fiap.baitersburger.core.domain.ports.out.order;

import br.com.fiap.baitersburger.core.domain.model.Order;

public interface UpdateOrderStatusOutputPort {
    void updateOrderStatus(Order order);
}
