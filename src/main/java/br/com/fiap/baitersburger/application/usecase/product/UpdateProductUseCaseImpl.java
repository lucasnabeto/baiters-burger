package br.com.fiap.baitersburger.application.usecase.product;

import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.UpdateProductUseCase;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductRepository;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private final ProductRepository productRepository;

    public UpdateProductUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void update(Product product) {
        productRepository.findById(product.getId());
        productRepository.update(product);
    }
}
