package br.com.fiap.baitersburger.domain.port.in.usecase.order;

import br.com.fiap.baitersburger.domain.model.Order;

import java.util.List;

public interface GetCurrentOrderUseCase {
    List<Order> getCurrentOrders();
}
