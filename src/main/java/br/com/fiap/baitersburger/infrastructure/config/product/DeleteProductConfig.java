package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.application.usecase.product.DeleteProductUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteProductConfig {
    @Bean
    public DeleteProductUseCaseImpl deleteProductUseCase(
            ProductDataSource productDataSource
    ){
        return new DeleteProductUseCaseImpl(productDataSource);
    }
}
