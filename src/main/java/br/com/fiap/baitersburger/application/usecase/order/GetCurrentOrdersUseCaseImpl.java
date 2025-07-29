package br.com.fiap.baitersburger.application.usecase.order;

import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.GetCurrentOrderUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.OrderGateway;

import java.util.Arrays;
import java.util.List;

public class GetCurrentOrdersUseCaseImpl implements GetCurrentOrderUseCase {

    private final OrderGateway orderGateway;

    public GetCurrentOrdersUseCaseImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public List<Order> getCurrentOrders() {
        return orderGateway.getCurrentOrders(Arrays.asList(OrderStatus.PREPARING, OrderStatus.RECEIVED, OrderStatus.READY));
    }
}
