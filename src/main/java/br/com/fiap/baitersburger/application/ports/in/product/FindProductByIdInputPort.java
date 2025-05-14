package br.com.fiap.baitersburger.application.ports.in.product;

import br.com.fiap.baitersburger.application.core.domain.Product;

import java.util.Optional;

public interface FindProductByIdInputPort {
    Product findById(String id);
}
