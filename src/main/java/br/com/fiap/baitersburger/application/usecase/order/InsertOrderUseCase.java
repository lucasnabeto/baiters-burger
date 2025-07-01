package br.com.fiap.baitersburger.application.usecase.order;

import java.util.List;

public interface InsertOrderUseCase {
    void insert(List<String> productsIds, String customerCpf);
}
