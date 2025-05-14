package br.com.fiap.baitersburger.application.ports.out.product;

import br.com.fiap.baitersburger.application.core.domain.Product;

import java.util.Optional;

public interface FindProductByIdOutputPort {
    Optional<Product> findById(String id);
}
