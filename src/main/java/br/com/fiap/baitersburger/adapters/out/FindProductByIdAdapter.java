package br.com.fiap.baitersburger.adapters.out;

import br.com.fiap.baitersburger.adapters.out.repository.ProductRepository;
import br.com.fiap.baitersburger.adapters.out.repository.mappers.ProductEntityMapper;
import br.com.fiap.baitersburger.application.core.domain.Product;
import br.com.fiap.baitersburger.application.ports.out.product.FindProductByIdOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindProductByIdAdapter implements FindProductByIdOutputPort {
    private final ProductRepository productRepository;

    private final ProductEntityMapper productEntityMapper;

    public FindProductByIdAdapter(ProductRepository productRepository, ProductEntityMapper productEntityMapper) {
        this.productRepository = productRepository;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id).map(productEntityMapper::toProduct);
    }
}
