package br.com.fiap.baitersburger.core.application.usecase.order;

import br.com.fiap.baitersburger.core.domain.model.Order;
import br.com.fiap.baitersburger.core.domain.model.OrderStatus;
import br.com.fiap.baitersburger.core.application.ports.in.order.InsertOrderInputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.order.InsertOrderOutputPort;

import java.time.LocalDateTime;

public class InsertOrderUseCase implements InsertOrderInputPort {
    private final InsertOrderOutputPort insertOrderOutputPort;

    public InsertOrderUseCase(InsertOrderOutputPort insertOrderOutputPort) {
        this.insertOrderOutputPort = insertOrderOutputPort;
    }

    @Override
    public void insert(Order order) {
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.RECEIVED);
        order.calculateTotalPrice();

        insertOrderOutputPort.insert(order);
    }
}
