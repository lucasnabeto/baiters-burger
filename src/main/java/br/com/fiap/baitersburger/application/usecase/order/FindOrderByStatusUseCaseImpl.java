package br.com.fiap.baitersburger.application.usecase.order;

import br.com.fiap.baitersburger.domain.port.in.usecase.order.FindOrderByStatusUseCase;
import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderDataSource;

import java.util.List;

public class FindOrderByStatusUseCaseImpl implements FindOrderByStatusUseCase {

    private final OrderDataSource orderDataSource;

    public FindOrderByStatusUseCaseImpl(OrderDataSource orderDataSource) {
        this.orderDataSource = orderDataSource;
    }

    @Override
    public List<Order> findByStatus(OrderStatus orderStatus) {
        return orderDataSource.findByStatus(orderStatus).stream().toList();
    }
}