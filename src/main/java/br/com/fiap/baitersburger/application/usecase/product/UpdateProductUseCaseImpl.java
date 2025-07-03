package br.com.fiap.baitersburger.application.usecase.product;

import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.UpdateProductUseCase;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private final ProductDataSource productDataSource;

    public UpdateProductUseCaseImpl(ProductDataSource productDataSource) {
        this.productDataSource = productDataSource;
    }

    @Override
    public void update(Product product) {
        productDataSource.findById(product.getId());
        productDataSource.update(product);
    }
}
