package br.com.fiap.baitersburger.core.domain.ports.out.order;

import br.com.fiap.baitersburger.core.domain.model.Order;

public interface InsertOrderOutputPort {
    void insert(Order order);
}
