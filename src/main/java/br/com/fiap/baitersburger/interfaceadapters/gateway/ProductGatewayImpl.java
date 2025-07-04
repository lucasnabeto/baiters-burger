package br.com.fiap.baitersburger.interfaceadapters.gateway;

import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.out.gateway.ProductGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;

import java.util.List;
import java.util.Optional;

public class ProductGatewayImpl implements ProductGateway {

    private final ProductDataSource productDataSource;

    public ProductGatewayImpl(ProductDataSource productDataSource) {
        this.productDataSource = productDataSource;
    }

    @Override
    public void insert(Product product) {
        this.productDataSource.insert(product);
    }

    @Override
    public void update(Product product) {
        this.productDataSource.update(product);
    }

    @Override
    public void delete(String id) {
        this.productDataSource.delete(id);
    }

    @Override
    public Optional<Product> findById(String id) {
        return this.productDataSource.findById(id);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return this.productDataSource.findByCategory(category);
    }
}
