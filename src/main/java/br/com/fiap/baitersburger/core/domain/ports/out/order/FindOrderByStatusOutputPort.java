package br.com.fiap.baitersburger.core.domain.ports.out.order;

import br.com.fiap.baitersburger.core.domain.enums.OrderStatus;
import br.com.fiap.baitersburger.core.domain.model.Order;

import java.util.List;

public interface FindOrderByStatusOutputPort {

    List<Order> findByStatus(OrderStatus orderStatus);

}
