package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.application.usecase.product.InsertProductUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.InsertProductUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.ProductGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertProductConfig {
    @Bean
    public InsertProductUseCase insertProductUseCase(ProductGateway productGateway) {
        return new InsertProductUseCaseImpl(productGateway);
    }
}
