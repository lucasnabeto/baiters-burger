package br.com.fiap.baitersburger.application.usecase.product;

import br.com.fiap.baitersburger.domain.model.Product;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.FindProductByCategoryUseCase;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;

import java.util.List;

public class FindProductByCategoryUseCaseImpl implements FindProductByCategoryUseCase {

    private final ProductDataSource productDataSource;

    public FindProductByCategoryUseCaseImpl(ProductDataSource productDataSource) {
        this.productDataSource = productDataSource;
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productDataSource.findByCategory(category)
                        .stream()
                        .toList();
    }
}
