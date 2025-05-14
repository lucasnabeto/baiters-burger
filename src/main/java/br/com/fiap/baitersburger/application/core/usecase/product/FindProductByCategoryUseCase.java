package br.com.fiap.baitersburger.application.core.usecase.product;

import br.com.fiap.baitersburger.application.core.domain.Product;
import br.com.fiap.baitersburger.application.ports.in.product.FindProductByCategoryInputPort;
import br.com.fiap.baitersburger.application.ports.out.product.FindProductByCategoryOutputPort;

import java.util.List;
import java.util.stream.Collectors;

public class FindProductByCategoryUseCase implements FindProductByCategoryInputPort {
    private final FindProductByCategoryOutputPort findProductByCategoryOutputPort;

    public FindProductByCategoryUseCase(FindProductByCategoryOutputPort findProductByCategoryOutputPort){
        this.findProductByCategoryOutputPort = findProductByCategoryOutputPort;
    }

    @Override
    public List<Product> findByCategory(String category) {
        return findProductByCategoryOutputPort
                        .findByCategory(category)
                        .stream()
                        .filter((p)-> p.getCategory().toString().equals(category))
                        .toList();
    }
}
