package br.com.fiap.baitersburger.application.ports.in.product;

import br.com.fiap.baitersburger.application.core.domain.Product;

public interface UpdateProductInputPort {
    void update(String id, Product product);
}
