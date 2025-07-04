package br.com.fiap.baitersburger.interfaceadapters.gateway;

import br.com.fiap.baitersburger.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.domain.model.Order;
import br.com.fiap.baitersburger.domain.port.out.gateway.OrderGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderDataSource;

import java.util.List;
import java.util.Optional;

public class OrderGatewayImpl implements OrderGateway {
    private final OrderDataSource dataSource;

    public OrderGatewayImpl(OrderDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Order order) {
        this.dataSource.insert(order);
    }

    @Override
    public void updateStatus(Order order) {
        this.dataSource.updateStatus(order);
    }

    @Override
    public Optional<Order> findById(String id) {
        return this.dataSource.findById(id);
    }

    @Override
    public List<Order> findByStatus(OrderStatus status) {
        return this.dataSource.findByStatus(status);
    }
}
