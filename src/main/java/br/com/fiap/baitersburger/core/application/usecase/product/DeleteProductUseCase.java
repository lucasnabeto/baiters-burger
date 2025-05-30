package br.com.fiap.baitersburger.core.application.usecase.product;

import br.com.fiap.baitersburger.core.application.ports.in.product.DeleteProductInputPort;
import br.com.fiap.baitersburger.core.application.ports.in.product.FindProductByIdInputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.product.DeleteProductOutputPort;

public class DeleteProductUseCase implements DeleteProductInputPort {
    private final DeleteProductOutputPort deleteProductOutputPort;
    private final FindProductByIdInputPort findProductByIdInputPort;

    public DeleteProductUseCase(DeleteProductOutputPort deleteProductOutputPort, FindProductByIdInputPort findProductByIdInputPort){
        this.deleteProductOutputPort = deleteProductOutputPort;
        this.findProductByIdInputPort = findProductByIdInputPort;
    }

    @Override
    public void delete(String id) {
        findProductByIdInputPort.findById(id);
        deleteProductOutputPort.delete(id);
    }
}
