package br.com.fiap.baitersburger.core.domain.ports.out.order;

import br.com.fiap.baitersburger.core.domain.model.Order;

import java.util.Optional;

public interface FindOrderByIdOutputPort {
    Optional<Order> findOrderById(String orderId);
}
