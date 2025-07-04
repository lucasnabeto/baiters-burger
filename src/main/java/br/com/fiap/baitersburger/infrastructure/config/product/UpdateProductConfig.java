package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.application.usecase.product.UpdateProductUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.in.usecase.product.UpdateProductUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.ProductGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.ProductDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateProductConfig
{
    @Bean
    public UpdateProductUseCase updateProductUseCase(ProductGateway productGateway) {
        return new UpdateProductUseCaseImpl(productGateway);
    }
}
