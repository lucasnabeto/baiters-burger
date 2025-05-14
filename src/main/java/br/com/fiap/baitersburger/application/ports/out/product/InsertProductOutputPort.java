package br.com.fiap.baitersburger.application.ports.out.product;

import br.com.fiap.baitersburger.application.core.domain.Product;

public interface InsertProductOutputPort {
    void insert(Product product);
}
