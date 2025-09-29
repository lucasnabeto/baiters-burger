package br.com.fiap.baitersburger.interfaceadapters.repository;


import br.com.fiap.baitersburger.domain.enums.Category;
import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import br.com.fiap.baitersburger.infrastructure.persistence.mapper.ProductEntityMapper;
import br.com.fiap.baitersburger.infrastructure.persistence.repository.ProductMySqlRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProductDataSourceMySqlImpl implements ProductDataSource {

    private final ProductMySqlRepository productMySqlRepository;
    private final ProductEntityMapper productEntityMapper;

    public ProductDataSourceMySqlImpl(ProductMySqlRepository productMySqlRepository, ProductEntityMapper productEntityMapper) {
        this.productMySqlRepository = productMySqlRepository;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public void insert(Product product) {
        var productMySqlEntity = productEntityMapper.toProductMySqlEntity(product);
        productMySqlEntity.setId(UUID.randomUUID().toString());
        productMySqlRepository.save(productMySqlEntity);
    }

    @Override
    public void update(Product product) {
        var productMySqlEntity = productEntityMapper.toProductMySqlEntity(product);
        productMySqlRepository.save(productMySqlEntity);
    }

    @Override
    public void delete(String id) {
        productMySqlRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(String id) {
        return productMySqlRepository.findById(id).map(productEntityMapper::toProduct);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productMySqlRepository.findByCategory(Category.valueOf(category))
                .stream()
                .map(productEntityMapper::toProduct).toList();
    }
}
