package br.com.fiap.baitersburger.domain.port.in.usecase.order;

import java.util.List;

public interface InsertOrderUseCase {
    void insert(List<String> productsIds, String customerCpf);
}
