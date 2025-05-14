package br.com.fiap.baitersburger.application.core.usecase.product;

import br.com.fiap.baitersburger.application.core.domain.Product;
import br.com.fiap.baitersburger.application.ports.in.product.InsertProductInputPort;
import br.com.fiap.baitersburger.application.ports.out.product.InsertProductOutputPort;

public class InsertProductUseCase implements InsertProductInputPort {

    private final InsertProductOutputPort insertProductOutputPort;

    public InsertProductUseCase(InsertProductOutputPort insertProductOutputPort){
        this.insertProductOutputPort = insertProductOutputPort;
    }

    @Override
    public void insert(Product product) {
        insertProductOutputPort.insert(product);
    }
}
