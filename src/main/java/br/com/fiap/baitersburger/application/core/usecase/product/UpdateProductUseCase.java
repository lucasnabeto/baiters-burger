package br.com.fiap.baitersburger.application.core.usecase.product;

import br.com.fiap.baitersburger.application.core.domain.Product;
import br.com.fiap.baitersburger.application.ports.in.product.FindProductByIdInputPort;
import br.com.fiap.baitersburger.application.ports.in.product.UpdateProductInputPort;
import br.com.fiap.baitersburger.application.ports.out.product.UpdateProductOutputPort;

public class UpdateProductUseCase implements UpdateProductInputPort {
    private final UpdateProductOutputPort updateProductOutputPort;

    private final FindProductByIdInputPort findProductByIdInputPort;

    public UpdateProductUseCase(UpdateProductOutputPort updateProductOutputPort, FindProductByIdInputPort findProductByIdInputPort){
        this.updateProductOutputPort = updateProductOutputPort;
        this.findProductByIdInputPort = findProductByIdInputPort;
    }

    @Override
    public void update(String id, Product product) {
        findProductByIdInputPort.findById(id);
        updateProductOutputPort.update(product);
    }
}
