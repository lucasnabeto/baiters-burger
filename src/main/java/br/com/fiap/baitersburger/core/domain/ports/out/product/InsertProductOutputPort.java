package br.com.fiap.baitersburger.core.domain.ports.out.product;

import br.com.fiap.baitersburger.core.domain.model.Product;

public interface InsertProductOutputPort {
    void insert(Product product);
}
