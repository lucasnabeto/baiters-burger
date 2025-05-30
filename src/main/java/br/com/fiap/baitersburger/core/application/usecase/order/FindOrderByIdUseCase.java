package br.com.fiap.baitersburger.core.application.usecase.order;

import br.com.fiap.baitersburger.core.application.ports.in.order.FindOrderByIdInputPort;
import br.com.fiap.baitersburger.core.domain.model.Order;
import br.com.fiap.baitersburger.core.domain.ports.out.order.FindOrderByIdOutputPort;
import br.com.fiap.baitersburger.core.exceptions.ExceptionMessages;
import br.com.fiap.baitersburger.core.exceptions.NotFoundException;

public class FindOrderByIdUseCase implements FindOrderByIdInputPort {
    private final FindOrderByIdOutputPort findOrderByIdOutputPort;

    public FindOrderByIdUseCase(FindOrderByIdOutputPort findOrderByIdOutputPort) {
        this.findOrderByIdOutputPort = findOrderByIdOutputPort;
    }

    @Override
    public Order findOrderById(String orderId) {
        return findOrderByIdOutputPort.findOrderById(orderId)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.ORDER_NOT_FOUND));
    }
}
