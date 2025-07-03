package br.com.fiap.baitersburger.application.usecase.product;

import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.InsertProductUseCase;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;

public class InsertProductUseCaseImpl implements InsertProductUseCase {

    private final ProductDataSource productDataSource;

    public InsertProductUseCaseImpl(ProductDataSource productDataSource) {
        this.productDataSource = productDataSource;
    }

    @Override
    public void insert(Product product) {
        productDataSource.insert(product);
    }
}
