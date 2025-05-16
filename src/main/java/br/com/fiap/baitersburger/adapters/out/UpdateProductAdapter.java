package br.com.fiap.baitersburger.adapters.out;

import br.com.fiap.baitersburger.adapters.out.repository.ProductRepository;
import br.com.fiap.baitersburger.adapters.out.repository.mappers.ProductEntityMapper;
import br.com.fiap.baitersburger.application.core.domain.Product;
import br.com.fiap.baitersburger.application.ports.out.product.UpdateProductOutputPort;
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
