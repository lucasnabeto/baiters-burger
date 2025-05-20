package br.com.fiap.baitersburger.core.domain.ports.out.product;

import br.com.fiap.baitersburger.core.domain.model.Product;

public interface UpdateProductOutputPort {
    void update(Product product);
}
