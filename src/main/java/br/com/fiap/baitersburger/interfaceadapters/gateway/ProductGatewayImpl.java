package br.com.fiap.baitersburger.interfaceadapters.gateway;

import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.out.gateway.ProductGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;

import java.util.List;
import java.util.Optional;

public class ProductGatewayImpl implements ProductGateway {
    public ProductGatewayImpl(ProductDataSource productDataSource) {
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findByCategory(String category) {
        return List.of();
    }
}
