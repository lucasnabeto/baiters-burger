package br.com.fiap.baitersburger.application.usecase.product;

import br.com.fiap.baitersburger.domain.model.Product;

public interface FindProductByIdUseCase {
    Product findById(String id);
}
