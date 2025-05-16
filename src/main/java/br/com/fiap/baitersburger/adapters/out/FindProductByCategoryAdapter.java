package br.com.fiap.baitersburger.adapters.out;

import br.com.fiap.baitersburger.adapters.in.controller.dto.ProductResponseDTO;
import br.com.fiap.baitersburger.adapters.in.controller.mapper.ProductMapper;
import br.com.fiap.baitersburger.adapters.out.repository.ProductRepository;
import br.com.fiap.baitersburger.application.core.domain.Product;
import br.com.fiap.baitersburger.application.ports.out.product.FindProductByCategoryOutputPort;
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
