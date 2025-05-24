package br.com.fiap.baitersburger.adapters.out.mongodb.adapter.product;

import br.com.fiap.baitersburger.adapters.out.mongodb.repository.ProductRepository;
import br.com.fiap.baitersburger.adapters.out.mongodb.repository.mappers.ProductEntityMapper;
import br.com.fiap.baitersburger.core.domain.model.Product;
import br.com.fiap.baitersburger.core.domain.ports.out.product.UpdateProductOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductAdapter implements UpdateProductOutputPort {
    private final ProductRepository productRepository;

    private final ProductEntityMapper productEntityMapper;

    public UpdateProductAdapter(ProductRepository productRepository, ProductEntityMapper productEntityMapper) {
        this.productRepository = productRepository;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public void update(Product product) {
        var productEntity = productEntityMapper.toProductEntity(product);
        productRepository.save(productEntity);
    }
}
