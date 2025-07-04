package br.com.fiap.baitersburger.application.usecase.product;

import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.FindProductByIdUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.ProductGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import br.com.fiap.baitersburger.domain.exception.ExceptionMessages;
import br.com.fiap.baitersburger.domain.exception.NotFoundException;

public class FindProductByIdUseCaseImpl implements FindProductByIdUseCase {

    private final ProductGateway productGateway;

    public FindProductByIdUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public Product findById(String id) {
        return productGateway.findById(id).orElseThrow(() -> new NotFoundException(ExceptionMessages.PRODUCT_NOT_FOUND));
    }
}
