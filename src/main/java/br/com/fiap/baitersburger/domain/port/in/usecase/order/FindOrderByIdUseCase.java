package br.com.fiap.baitersburger.domain.port.in.usecase.order;

import br.com.fiap.baitersburger.domain.model.Order;

public interface FindOrderByIdUseCase {
    Order findOrderById(String orderId);
}
