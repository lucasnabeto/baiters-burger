package br.com.fiap.baitersburger.core.domain.ports.out.product;

import br.com.fiap.baitersburger.core.domain.model.Product;

import java.util.Optional;

public interface FindProductByIdOutputPort {
    Optional<Product> findById(String id);
}
