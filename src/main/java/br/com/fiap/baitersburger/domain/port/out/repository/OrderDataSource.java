package br.com.fiap.baitersburger.domain.port.out.repository;

import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDataSource {
    Order insert(Order order);
    void updateStatus(Order order);
    Optional<Order> findById(String id);
    List<Order> findByStatus(OrderStatus status);
    List<Order> getCurrentOrders(List<OrderStatus> statuses);
}
