package br.com.fiap.baitersburger.application.usecase.product;

import br.com.fiap.baitersburger.domain.port.in.usecase.product.DeleteProductUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.ProductGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;

public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    private final ProductGateway productGateway;

    public DeleteProductUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public void delete(String id) {
        productGateway.findById(id);
        productGateway.delete(id);
    }
}
