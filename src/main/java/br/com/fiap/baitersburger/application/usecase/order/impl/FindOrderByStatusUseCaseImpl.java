package br.com.fiap.baitersburger.application.usecase.order.impl;

import br.com.fiap.baitersburger.application.usecase.order.FindOrderByStatusUseCase;
import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.domain.port.repository.OrderRepository;

import java.util.List;

public class FindOrderByStatusUseCaseImpl implements FindOrderByStatusUseCase {

    private final OrderRepository orderRepository;

    public FindOrderByStatusUseCaseImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findByStatus(OrderStatus orderStatus) {
        return orderRepository.findByStatus(orderStatus).stream().toList();
    }
}