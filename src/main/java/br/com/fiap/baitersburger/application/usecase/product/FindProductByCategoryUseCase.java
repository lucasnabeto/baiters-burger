package br.com.fiap.baitersburger.application.usecase.product;

import br.com.fiap.baitersburger.domain.model.Product;

import java.util.List;

public interface FindProductByCategoryUseCase {
    List<Product> findByCategory(String category);
}
