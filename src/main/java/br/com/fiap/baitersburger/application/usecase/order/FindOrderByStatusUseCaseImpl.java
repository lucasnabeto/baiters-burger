package br.com.fiap.baitersburger.application.usecase.order;

import br.com.fiap.baitersburger.domain.port.in.usecase.order.FindOrderByStatusUseCase;
import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.domain.port.out.gateway.OrderGateway;

import java.util.List;

public class FindOrderByStatusUseCaseImpl implements FindOrderByStatusUseCase {

    private final OrderGateway orderGateway;

    public FindOrderByStatusUseCaseImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public List<Order> findByStatus(OrderStatus orderStatus) {
        return orderGateway.findByStatus(orderStatus).stream().toList();
    }
}