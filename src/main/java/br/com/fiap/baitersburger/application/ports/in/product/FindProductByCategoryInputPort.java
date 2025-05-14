package br.com.fiap.baitersburger.application.ports.in.product;

import br.com.fiap.baitersburger.application.core.domain.Product;

import java.util.List;

public interface FindProductByCategoryInputPort {
    List<Product> findByCategory(String category);
}
