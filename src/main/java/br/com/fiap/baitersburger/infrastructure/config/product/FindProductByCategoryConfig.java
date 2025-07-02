package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.application.usecase.product.FindProductByCategoryUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductRepository;
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
