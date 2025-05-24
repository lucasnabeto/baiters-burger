package br.com.fiap.baitersburger.core.application.usecase.product;

import br.com.fiap.baitersburger.core.domain.model.Product;
import br.com.fiap.baitersburger.core.application.ports.in.product.FindProductByIdInputPort;
import br.com.fiap.baitersburger.core.application.ports.in.product.UpdateProductInputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.product.UpdateProductOutputPort;

public class UpdateProductUseCase implements UpdateProductInputPort {
    private final UpdateProductOutputPort updateProductOutputPort;

    private final FindProductByIdInputPort findProductByIdInputPort;

    public UpdateProductUseCase(UpdateProductOutputPort updateProductOutputPort, FindProductByIdInputPort findProductByIdInputPort){
        this.updateProductOutputPort = updateProductOutputPort;
        this.findProductByIdInputPort = findProductByIdInputPort;
    }

    @Override
    public void update(Product product) {
        findProductByIdInputPort.findById(product.getId());
        updateProductOutputPort.update(product);
    }
}
