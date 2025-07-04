package br.com.fiap.baitersburger.application.usecase.product;

import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.UpdateProductUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.ProductGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private final ProductGateway productGateway;

    public UpdateProductUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public void update(Product product) {
        productGateway.findById(product.getId());
        productGateway.update(product);
    }
}
