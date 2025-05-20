package br.com.fiap.baitersburger.adapters.out.mongodb.adapter.product;

import br.com.fiap.baitersburger.adapters.in.controller.mapper.ProductMapper;
import br.com.fiap.baitersburger.adapters.out.mongodb.repository.ProductRepository;
import br.com.fiap.baitersburger.core.domain.model.Product;
import br.com.fiap.baitersburger.core.domain.ports.out.product.FindProductByCategoryOutputPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindProductByCategoryAdapter implements FindProductByCategoryOutputPort {
    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public FindProductByCategoryAdapter(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category)
                .stream()
                .map(productMapper::toProduct).toList();
    }
}
