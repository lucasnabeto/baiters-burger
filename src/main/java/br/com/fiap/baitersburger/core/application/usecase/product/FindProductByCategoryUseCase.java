package br.com.fiap.baitersburger.core.application.usecase.product;

import br.com.fiap.baitersburger.core.domain.model.Product;
import br.com.fiap.baitersburger.core.application.ports.in.product.FindProductByCategoryInputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.product.FindProductByCategoryOutputPort;

import java.util.List;

public class FindProductByCategoryUseCase implements FindProductByCategoryInputPort {
    private final FindProductByCategoryOutputPort findProductByCategoryOutputPort;

    public FindProductByCategoryUseCase(FindProductByCategoryOutputPort findProductByCategoryOutputPort){
        this.findProductByCategoryOutputPort = findProductByCategoryOutputPort;
    }

    @Override
    public List<Product> findByCategory(String category) {
        return findProductByCategoryOutputPort.findByCategory(category)
                        .stream()
                        .toList();
    }
}
