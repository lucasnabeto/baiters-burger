package br.com.fiap.baitersburger.core.application.ports.in.product;

import br.com.fiap.baitersburger.core.domain.model.Product;

public interface UpdateProductInputPort {
    void update(Product product);
}
