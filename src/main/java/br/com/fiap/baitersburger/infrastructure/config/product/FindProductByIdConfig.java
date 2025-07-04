package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.application.usecase.product.FindProductByIdUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.FindProductByIdUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.ProductGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProductByIdConfig {
    @Bean
    public FindProductByIdUseCase findProductByIdUseCase(ProductGateway productGateway) {
        return new FindProductByIdUseCaseImpl(productGateway);
    }
}
