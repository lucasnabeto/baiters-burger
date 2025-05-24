package br.com.fiap.baitersburger.core.application.ports.in.product;

import br.com.fiap.baitersburger.core.domain.model.Product;

import java.util.List;

public interface FindProductByCategoryInputPort {
    List<Product> findByCategory(String category);
}
