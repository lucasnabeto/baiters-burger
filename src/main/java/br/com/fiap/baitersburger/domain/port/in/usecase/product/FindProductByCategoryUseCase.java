package br.com.fiap.baitersburger.domain.port.in.usecase.product;

import br.com.fiap.baitersburger.domain.model.Product;

import java.util.List;

public interface FindProductByCategoryUseCase {
    List<Product> findByCategory(String category);
}
