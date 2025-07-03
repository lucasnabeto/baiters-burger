package br.com.fiap.baitersburger.interfaceadapters.repository;


import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import br.com.fiap.baitersburger.infrastructure.persistence.mapper.ProductEntityMapper;
import br.com.fiap.baitersburger.infrastructure.persistence.repository.ProductMongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository implements ProductDataSource { // <= Implementa a porta do domínio

    private final ProductMongoRepository productMongoRepository;
    private final ProductEntityMapper productEntityMapper;

    public ProductRepository(ProductMongoRepository productMongoRepository, ProductEntityMapper productEntityMapper) {
        this.productMongoRepository = productMongoRepository;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public void insert(Product product) {
        var productEntity = productEntityMapper.toProductEntity(product);
        productMongoRepository.insert(productEntity);
    }

    @Override
    public void update(Product product) {
        var productEntity = productEntityMapper.toProductEntity(product);
        productMongoRepository.save(productEntity);
    }

    @Override
    public void delete(String id) {
        productMongoRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(String id) {
        return productMongoRepository.findById(id).map(productEntityMapper::toProduct);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productMongoRepository.findByCategory(category)
                .stream()
                .map(productEntityMapper::toProduct).toList();
    }
}
