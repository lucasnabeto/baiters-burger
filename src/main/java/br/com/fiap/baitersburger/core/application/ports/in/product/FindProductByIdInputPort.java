package br.com.fiap.baitersburger.core.application.ports.in.product;

import br.com.fiap.baitersburger.core.domain.model.Product;

public interface FindProductByIdInputPort {
    Product findById(String id);
}
