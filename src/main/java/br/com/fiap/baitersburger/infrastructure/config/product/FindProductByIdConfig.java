package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.application.usecase.product.impl.FindProductByIdUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProductByIdConfig {
    @Bean
    public FindProductByIdUseCaseImpl findProductByIdUseCase(
            ProductRepository productRepository
    ) {
        return new FindProductByIdUseCaseImpl(productRepository);
    }
}
