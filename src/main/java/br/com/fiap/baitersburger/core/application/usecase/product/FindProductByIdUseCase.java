package br.com.fiap.baitersburger.core.application.usecase.product;

import br.com.fiap.baitersburger.core.domain.model.Product;
import br.com.fiap.baitersburger.core.application.ports.in.product.FindProductByIdInputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.product.FindProductByIdOutputPort;
import br.com.fiap.baitersburger.core.exceptions.ExceptionMessages;
import br.com.fiap.baitersburger.core.exceptions.NotFoundException;

public class FindProductByIdUseCase implements FindProductByIdInputPort {
    private final FindProductByIdOutputPort findProductByIdOutputPort;

    public FindProductByIdUseCase(FindProductByIdOutputPort findProductByIdOutputPort){
        this.findProductByIdOutputPort = findProductByIdOutputPort;
    }

    @Override
    public Product findById(String id) {
        return findProductByIdOutputPort.findById(id).orElseThrow(() -> new NotFoundException(ExceptionMessages.PRODUCT_NOT_FOUND));
    }
}
