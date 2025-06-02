package br.com.fiap.baitersburger.adapters.out.mongodb.adapter.order;

import br.com.fiap.baitersburger.adapters.out.mongodb.repository.OrderRepository;
import br.com.fiap.baitersburger.adapters.out.mongodb.repository.mappers.OrderEntityMapper;
import br.com.fiap.baitersburger.core.domain.model.Order;
import br.com.fiap.baitersburger.core.domain.ports.out.order.UpdateOrderStatusOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateOrderStatusAdapter implements UpdateOrderStatusOutputPort {
    private final OrderRepository orderRepository;
    private final OrderEntityMapper orderEntityMapper;

    public UpdateOrderStatusAdapter(OrderRepository orderRepository, OrderEntityMapper orderEntityMapper) {
        this.orderRepository = orderRepository;
        this.orderEntityMapper = orderEntityMapper;
    }

    @Override
    public void updateOrderStatus(Order order) {
        var orderEntity = orderEntityMapper.toOrderEntity(order);
        orderRepository.save(orderEntity);
    }
}
