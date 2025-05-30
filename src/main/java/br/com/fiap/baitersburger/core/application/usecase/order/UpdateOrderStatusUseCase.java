package br.com.fiap.baitersburger.core.application.usecase.order;

import br.com.fiap.baitersburger.core.application.ports.in.order.FindOrderByIdInputPort;
import br.com.fiap.baitersburger.core.application.ports.in.order.UpdateOrderStatusInputPort;
import br.com.fiap.baitersburger.core.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.core.domain.ports.out.order.UpdateOrderStatusOutputPort;

public class UpdateOrderStatusUseCase implements UpdateOrderStatusInputPort {
    private final FindOrderByIdInputPort findOrderByIdInputPort;
    private final UpdateOrderStatusOutputPort updateOrderStatusOutputPort;

    public UpdateOrderStatusUseCase(FindOrderByIdInputPort findOrderByIdInputPort, UpdateOrderStatusOutputPort updateOrderStatusOutputPort) {
        this.findOrderByIdInputPort = findOrderByIdInputPort;
        this.updateOrderStatusOutputPort = updateOrderStatusOutputPort;
    }

    @Override
    public void updateOrderStatus(String orderId, OrderStatus status) {
        var order = findOrderByIdInputPort.findOrderById(orderId);
        order.setStatus(status);
        updateOrderStatusOutputPort.updateOrderStatus(order);
    }
}
