package br.com.fiap.baitersburger.interfaceadapters.repository;

import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderDataSource;
import br.com.fiap.baitersburger.infrastructure.persistence.mapper.OrderEntityMapper;
import br.com.fiap.baitersburger.infrastructure.persistence.repository.OrderMySqlRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class OrderDataSourceMySqlImpl implements OrderDataSource {

    private final OrderMySqlRepository orderMySqlRepository;
    private final OrderEntityMapper orderEntityMapper;

    public OrderDataSourceMySqlImpl(OrderMySqlRepository orderMySqlRepository, OrderEntityMapper orderEntityMapper) {
        this.orderMySqlRepository = orderMySqlRepository;
        this.orderEntityMapper = orderEntityMapper;
    }

    @Override
    public Order insert(Order order) {
        var orderMySqlEntity = orderEntityMapper.toOrderMySqlEntity(order);
        orderMySqlEntity.setId(UUID.randomUUID().toString());
        return orderEntityMapper.toOrder(orderMySqlRepository.save(orderMySqlEntity));
    }

    @Override
    public void updateStatus(Order order) {
        var orderMySqlEntity = orderEntityMapper.toOrderMySqlEntity(order);
        orderMySqlRepository.save(orderMySqlEntity);
    }

    @Override
    public Optional<Order> findById(String id) {
        return orderMySqlRepository.findById(id).map(orderEntityMapper::toOrder);
    }

    @Override
    public List<Order> findByStatus(OrderStatus status) {
        return orderMySqlRepository.findByStatus(status).
                stream().
                map(orderEntityMapper::toOrder).
                toList();
    }

    @Override
    public List<Order> getCurrentOrders(List<OrderStatus> statuses) {
        return orderMySqlRepository.findByStatuses(statuses).stream().map(orderEntityMapper::toOrder).toList();
    }


}
