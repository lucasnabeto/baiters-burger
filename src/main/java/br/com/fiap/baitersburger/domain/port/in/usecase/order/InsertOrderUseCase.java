package br.com.fiap.baitersburger.domain.port.in.usecase.order;

import br.com.fiap.baitersburger.domain.model.Order;

import java.util.List;

public interface InsertOrderUseCase {
    Order insert(List<String> productsIds, String customerCpf);
}
