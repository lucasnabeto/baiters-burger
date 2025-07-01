package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.application.usecase.product.impl.FindProductByCategoryUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProductByCategoryConfig {
    @Bean
    public FindProductByCategoryUseCaseImpl findProductByCategoryUseCase(
            ProductRepository productRepository
    ) {
        return new FindProductByCategoryUseCaseImpl(productRepository);
    }
}
