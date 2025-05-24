package br.com.fiap.baitersburger.adapters.out.mongodb.adapter.order;

import br.com.fiap.baitersburger.adapters.out.mongodb.repository.OrderRepository;
import br.com.fiap.baitersburger.adapters.out.mongodb.repository.mappers.OrderEntityMapper;
import br.com.fiap.baitersburger.core.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.core.domain.model.Order;
import br.com.fiap.baitersburger.core.domain.ports.out.order.FindOrderByStatusOutputPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindOrderByStatusAdapter implements FindOrderByStatusOutputPort {

    private final OrderRepository orderRepository;

    private final OrderEntityMapper orderEntityMapper;

    public FindOrderByStatusAdapter(OrderRepository orderRepository, OrderEntityMapper orderEntityMapper) {
        this.orderRepository = orderRepository;
        this.orderEntityMapper = orderEntityMapper;
    }

    @Override
    public List<Order> findByStatus(OrderStatus orderStatus) {
       return orderRepository.findByStatus(orderStatus).
               stream().
               map(orderEntityMapper::toOrder).
               toList();
    }
}
