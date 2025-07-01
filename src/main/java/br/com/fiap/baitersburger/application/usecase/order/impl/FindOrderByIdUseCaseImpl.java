package br.com.fiap.baitersburger.application.usecase.order.impl;

import br.com.fiap.baitersburger.application.usecase.order.FindOrderByIdUseCase;
import br.com.fiap.baitersburger.domain.exception.ExceptionMessages;
import br.com.fiap.baitersburger.domain.exception.NotFoundException;
import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.domain.port.repository.OrderRepository;

public class FindOrderByIdUseCaseImpl implements FindOrderByIdUseCase {


    private final OrderRepository orderRepository;

    public FindOrderByIdUseCaseImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findOrderById(String orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.ORDER_NOT_FOUND));
    }
}
