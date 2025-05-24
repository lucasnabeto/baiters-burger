package br.com.fiap.baitersburger.core.application.usecase.product;

import br.com.fiap.baitersburger.core.domain.model.Product;
import br.com.fiap.baitersburger.core.application.ports.in.product.InsertProductInputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.product.InsertProductOutputPort;

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
