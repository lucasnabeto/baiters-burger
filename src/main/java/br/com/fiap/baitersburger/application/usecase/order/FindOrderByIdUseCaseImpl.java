package br.com.fiap.baitersburger.application.usecase.order;

import br.com.fiap.baitersburger.domain.port.in.usecase.order.FindOrderByIdUseCase;
import br.com.fiap.baitersburger.domain.exception.ExceptionMessages;
import br.com.fiap.baitersburger.domain.exception.NotFoundException;
import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.domain.port.out.gateway.OrderGateway;

public class FindOrderByIdUseCaseImpl implements FindOrderByIdUseCase {
    private final OrderGateway orderGateway;

    public FindOrderByIdUseCaseImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public Order findOrderById(String orderId) {
        return orderGateway.findById(orderId)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.ORDER_NOT_FOUND));
    }
}
