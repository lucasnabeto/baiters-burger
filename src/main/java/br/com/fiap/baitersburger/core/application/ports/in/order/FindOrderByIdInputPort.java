package br.com.fiap.baitersburger.core.application.ports.in.order;

import br.com.fiap.baitersburger.core.domain.model.Order;

public interface FindOrderByIdInputPort {
    Order findOrderById(String orderId);
}
