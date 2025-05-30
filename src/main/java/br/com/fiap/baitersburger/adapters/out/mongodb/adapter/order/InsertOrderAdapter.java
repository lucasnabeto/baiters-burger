package br.com.fiap.baitersburger.adapters.out.mongodb.adapter.order;

import br.com.fiap.baitersburger.adapters.out.mongodb.repository.OrderRepository;
import br.com.fiap.baitersburger.adapters.out.mongodb.repository.mappers.OrderEntityMapper;
import br.com.fiap.baitersburger.core.domain.model.Order;
import br.com.fiap.baitersburger.core.domain.ports.out.order.InsertOrderOutputPort;
import org.springframework.stereotype.Component;

@Component
public class InsertOrderAdapter implements InsertOrderOutputPort {
    private final OrderRepository orderRepository;
    private final OrderEntityMapper orderEntityMapper;

    public InsertOrderAdapter(OrderRepository orderRepository, OrderEntityMapper orderEntityMapper) {
        this.orderRepository = orderRepository;
        this.orderEntityMapper = orderEntityMapper;
    }

    @Override
    public void insert(Order order) {
        var orderEntity = orderEntityMapper.toOrderEntity(order);
        orderRepository.insert(orderEntity);
    }
}
