package br.com.fiap.baitersburger.interfaceadapters.repository;

import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderDataSource;
import br.com.fiap.baitersburger.infrastructure.persistence.mapper.OrderEntityMapper;
import br.com.fiap.baitersburger.infrastructure.persistence.repository.OrderMongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderRepository implements OrderDataSource {

    private final OrderMongoRepository orderMongoRepository;
    private final OrderEntityMapper orderEntityMapper;

    public OrderRepository(OrderMongoRepository orderMongoRepository, OrderEntityMapper orderEntityMapper) {
        this.orderMongoRepository = orderMongoRepository;
        this.orderEntityMapper = orderEntityMapper;
    }

    @Override
    public void insert(Order order) {
        var orderEntity = orderEntityMapper.toOrderEntity(order);
        orderMongoRepository.insert(orderEntity);
    }

    @Override
    public void updateStatus(Order order) {
        var orderEntity = orderEntityMapper.toOrderEntity(order);
        orderMongoRepository.save(orderEntity);
    }

    @Override
    public Optional<Order> findById(String id) {
        return orderMongoRepository.findById(id).map(orderEntityMapper::toOrder);
    }

    @Override
    public List<Order> findByStatus(OrderStatus status) {
        return orderMongoRepository.findByStatus(status).
                stream().
                map(orderEntityMapper::toOrder).
                toList();
    }
}
