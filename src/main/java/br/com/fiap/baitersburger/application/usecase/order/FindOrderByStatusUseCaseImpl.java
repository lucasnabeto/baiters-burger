package br.com.fiap.baitersburger.application.usecase.order;

import br.com.fiap.baitersburger.domain.port.in.usecase.order.FindOrderByStatusUseCase;
import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.domain.port.out.gateway.OrderGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderDataSource;

import java.util.List;

public class FindOrderByStatusUseCaseImpl implements FindOrderByStatusUseCase {

    private final OrderGateway orderDataSource;

    public FindOrderByStatusUseCaseImpl(OrderGateway orderGateway) {
        this.orderDataSource = orderGateway;
    }

    @Override
    public List<Order> findByStatus(OrderStatus orderStatus) {
        return orderDataSource.findByStatus(orderStatus).stream().toList();
    }
}