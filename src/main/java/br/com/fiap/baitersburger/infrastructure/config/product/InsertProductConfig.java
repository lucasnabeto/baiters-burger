package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.application.usecase.product.impl.InsertProductUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertProductConfig {
    @Bean
    public InsertProductUseCaseImpl insertProductUseCase(
            ProductRepository productRepository
    ) {
        return new InsertProductUseCaseImpl(productRepository);
    }
}
