package br.com.fiap.baitersburger.core.application.ports.in.order;

import br.com.fiap.baitersburger.core.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.core.domain.model.Order;

import java.util.List;

public interface FindOrderByStatusInputPort {
    List<Order> findByStatus(OrderStatus orderStatus);
}
