package br.com.fiap.baitersburger.domain.port.out.repository;

import br.com.fiap.baitersburger.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDataSource {

    void insert(Product product);
    void update(Product product);
    void delete(String id);
    Optional<Product> findById(String id);
    List<Product> findByCategory(String category);

}
