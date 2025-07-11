package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.application.usecase.product.FindProductByCategoryUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.FindProductByCategoryUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.ProductGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProductByCategoryConfig {
    @Bean
    public FindProductByCategoryUseCase findProductByCategoryUseCase(ProductGateway productGateway) {
        return new FindProductByCategoryUseCaseImpl(productGateway);
    }
}
