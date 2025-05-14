package br.com.fiap.baitersburger.application.core.usecase.product;

import br.com.fiap.baitersburger.application.core.domain.Product;
import br.com.fiap.baitersburger.application.ports.in.product.FindProductByIdInputPort;
import br.com.fiap.baitersburger.application.ports.out.product.FindProductByIdOutputPort;

import java.util.Optional;

public class FindProductByIdUseCase implements FindProductByIdInputPort {
    private final FindProductByIdOutputPort findProductByIdOutputPort;

    public FindProductByIdUseCase(FindProductByIdOutputPort findProductByIdOutputPort){
        this.findProductByIdOutputPort = findProductByIdOutputPort;
    }

    @Override
    public Product findById(String id) {
        return findProductByIdOutputPort.findById(id).orElseThrow(()->new RuntimeException("Product not found!"));
    }
}
