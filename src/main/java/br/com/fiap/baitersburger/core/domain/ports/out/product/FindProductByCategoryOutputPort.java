package br.com.fiap.baitersburger.core.domain.ports.out.product;

import br.com.fiap.baitersburger.core.domain.model.Product;

import java.util.List;

public interface FindProductByCategoryOutputPort {
    List<Product> findByCategory(String category);
}
