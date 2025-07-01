package br.com.fiap.baitersburger.application.usecase.order;

import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.model.Order;

import java.util.List;

public interface FindOrderByStatusUseCase {
    List<Order> findByStatus(OrderStatus orderStatus);
}
