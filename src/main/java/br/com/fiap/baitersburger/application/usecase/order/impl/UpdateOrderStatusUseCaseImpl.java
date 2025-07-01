package br.com.fiap.baitersburger.application.usecase.order.impl;

import br.com.fiap.baitersburger.application.usecase.order.UpdateOrderStatusUseCase;
import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.exception.ExceptionMessages;
import br.com.fiap.baitersburger.domain.exception.NotFoundException;
import br.com.fiap.baitersburger.domain.port.repository.OrderRepository;

public class UpdateOrderStatusUseCaseImpl implements UpdateOrderStatusUseCase {
    private final OrderRepository orderRepository;

    public UpdateOrderStatusUseCaseImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void updateOrderStatus(String orderId, OrderStatus status) {
        var order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.ORDER_NOT_FOUND));

        order.setStatus(status);
        orderRepository.updateStatus(order);
    }
}
