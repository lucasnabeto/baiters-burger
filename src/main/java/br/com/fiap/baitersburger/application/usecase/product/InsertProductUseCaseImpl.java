package br.com.fiap.baitersburger.application.usecase.product;

import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.InsertProductUseCase;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductRepository;

public class InsertProductUseCaseImpl implements InsertProductUseCase {

    private final ProductRepository productRepository;

    public InsertProductUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void insert(Product product) {
        productRepository.insert(product);
    }
}
