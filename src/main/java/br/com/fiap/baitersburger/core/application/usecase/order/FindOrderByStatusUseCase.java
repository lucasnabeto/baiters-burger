package br.com.fiap.baitersburger.core.application.usecase.order;

import br.com.fiap.baitersburger.core.application.ports.in.order.FindOrderByStatusInputPort;
import br.com.fiap.baitersburger.core.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.core.domain.model.Order;
import br.com.fiap.baitersburger.core.domain.ports.out.order.FindOrderByStatusOutputPort;

import java.util.List;

public class FindOrderByStatusUseCase implements FindOrderByStatusInputPort {
    private final FindOrderByStatusOutputPort findOrderByStatusOutputPort;

    public FindOrderByStatusUseCase(FindOrderByStatusOutputPort findOrderByStatusOutputPort) {
        this.findOrderByStatusOutputPort = findOrderByStatusOutputPort;
    }

    @Override
    public List<Order> findByStatus(OrderStatus orderStatus) {
        return findOrderByStatusOutputPort.findByStatus(orderStatus).stream().toList();
    }
}