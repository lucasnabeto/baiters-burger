package br.com.fiap.baitersburger.application.ports.out.product;

import br.com.fiap.baitersburger.application.core.domain.Product;

import java.util.List;

public interface FindProductByCategoryOutputPort {
    List<Product> findByCategory(String category);
}
