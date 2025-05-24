package br.com.fiap.baitersburger.adapters.out.mongodb.adapter.product;

import br.com.fiap.baitersburger.adapters.out.mongodb.repository.ProductRepository;
import br.com.fiap.baitersburger.core.domain.ports.out.product.DeleteProductOutputPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductAdapter implements DeleteProductOutputPort {
    private final ProductRepository productRepository;

    public DeleteProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }
}
