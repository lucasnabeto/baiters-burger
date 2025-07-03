package br.com.fiap.baitersburger.application.usecase.product;

import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.FindProductByIdUseCase;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import br.com.fiap.baitersburger.domain.exception.ExceptionMessages;
import br.com.fiap.baitersburger.domain.exception.NotFoundException;

public class FindProductByIdUseCaseImpl implements FindProductByIdUseCase {

    private final ProductDataSource productDataSource;

    public FindProductByIdUseCaseImpl(ProductDataSource productDataSource) {
        this.productDataSource = productDataSource;
    }

    @Override
    public Product findById(String id) {
        return productDataSource.findById(id).orElseThrow(() -> new NotFoundException(ExceptionMessages.PRODUCT_NOT_FOUND));
    }
}
