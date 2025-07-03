package br.com.fiap.baitersburger.application.usecase.product;

import br.com.fiap.baitersburger.domain.port.in.usecase.product.DeleteProductUseCase;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;

public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    private final ProductDataSource productDataSource;

    public DeleteProductUseCaseImpl(ProductDataSource productDataSource) {
        this.productDataSource = productDataSource;
    }

    @Override
    public void delete(String id) {
        productDataSource.findById(id);
        productDataSource.delete(id);
    }
}
