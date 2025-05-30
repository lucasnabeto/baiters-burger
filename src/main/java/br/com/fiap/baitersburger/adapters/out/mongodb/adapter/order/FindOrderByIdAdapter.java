package br.com.fiap.baitersburger.adapters.out.mongodb.adapter.order;

import br.com.fiap.baitersburger.adapters.out.mongodb.repository.OrderRepository;
import br.com.fiap.baitersburger.adapters.out.mongodb.repository.mappers.OrderEntityMapper;
import br.com.fiap.baitersburger.core.domain.model.Order;
import br.com.fiap.baitersburger.core.domain.ports.out.order.FindOrderByIdOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindOrderByIdAdapter implements FindOrderByIdOutputPort {
    private final OrderRepository orderRepository;
    private final OrderEntityMapper orderEntityMapper;

    public FindOrderByIdAdapter(OrderRepository orderRepository, OrderEntityMapper orderEntityMapper) {
        this.orderRepository = orderRepository;
        this.orderEntityMapper = orderEntityMapper;
    }

    @Override
    public Optional<Order> findOrderById(String orderId) {
        return  orderRepository.findById(orderId).map(orderEntityMapper::toOrder);
    }
}
