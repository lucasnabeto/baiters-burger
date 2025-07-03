package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.application.usecase.product.InsertProductUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertProductConfig {
    @Bean
    public InsertProductUseCaseImpl insertProductUseCase(
            ProductDataSource productDataSource
    ) {
        return new InsertProductUseCaseImpl(productDataSource);
    }
}
