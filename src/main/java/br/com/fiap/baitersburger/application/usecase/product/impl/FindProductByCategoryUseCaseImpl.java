package br.com.fiap.baitersburger.application.usecase.product.impl;

import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.application.usecase.product.FindProductByCategoryUseCase;
import br.com.fiap.baitersburger.domain.port.repository.ProductRepository;

import java.util.List;

public class FindProductByCategoryUseCaseImpl implements FindProductByCategoryUseCase {

    private final ProductRepository productRepository;

    public FindProductByCategoryUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category)
                        .stream()
                        .toList();
    }
}
