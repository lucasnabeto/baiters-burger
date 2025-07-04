package br.com.fiap.baitersburger.domain.port.in.usecase.product;

import br.com.fiap.baitersburger.domain.model.Product;

public interface FindProductByIdUseCase {
    Product findById(String id);
}
