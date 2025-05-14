package br.com.fiap.baitersburger.application.ports.in.product;

import br.com.fiap.baitersburger.application.core.domain.Product;

public interface InsertProductInputPort {
    void insert(Product product);
}
