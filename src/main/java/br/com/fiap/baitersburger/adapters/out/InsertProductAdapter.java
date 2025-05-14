package br.com.fiap.baitersburger.adapters.out;

import br.com.fiap.baitersburger.adapters.out.repository.ProductRepository;
import br.com.fiap.baitersburger.adapters.out.repository.mappers.ProductEntityMapper;
import br.com.fiap.baitersburger.application.core.domain.Product;
import br.com.fiap.baitersburger.application.ports.out.product.InsertProductOutputPort;
import org.springframework.stereotype.Component;

@Component
public class InsertProductAdapter implements InsertProductOutputPort {

    private final ProductRepository productRepository;

    private final ProductEntityMapper productEntityMapper;

    public InsertProductAdapter(ProductRepository productRepository, ProductEntityMapper productEntityMapper){
        this.productRepository = productRepository;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public void insert(Product product) {
        var productEntity = productEntityMapper.toProductEntity(product);
        productRepository.insert(productEntity);
    }
}
