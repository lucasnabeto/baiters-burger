package br.com.fiap.baitersburger.application.usecase.product;

import br.com.fiap.baitersburger.domain.port.in.usecase.product.DeleteProductUseCase;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductRepository;

public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    private final ProductRepository productRepository;

    public DeleteProductUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void delete(String id) {
        productRepository.findById(id);
        productRepository.delete(id);
    }
}
