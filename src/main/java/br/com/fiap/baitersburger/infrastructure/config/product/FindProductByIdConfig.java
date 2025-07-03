package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.application.usecase.product.FindProductByIdUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProductByIdConfig {
    @Bean
    public FindProductByIdUseCaseImpl findProductByIdUseCase(
            ProductDataSource productDataSource
    ) {
        return new FindProductByIdUseCaseImpl(productDataSource);
    }
}
