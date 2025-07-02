package br.com.fiap.baitersburger.application.usecase.product;

import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.FindProductByIdUseCase;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductRepository;
import br.com.fiap.baitersburger.domain.exception.ExceptionMessages;
import br.com.fiap.baitersburger.domain.exception.NotFoundException;

public class FindProductByIdUseCaseImpl implements FindProductByIdUseCase {

    private final ProductRepository productRepository;

    public FindProductByIdUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException(ExceptionMessages.PRODUCT_NOT_FOUND));
    }
}
