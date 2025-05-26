package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.core.application.usecase.product.UpdateProductUseCase;
import br.com.fiap.baitersburger.core.application.ports.in.product.FindProductByIdInputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.product.UpdateProductOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateProductConfig
{
    @Bean
    public UpdateProductUseCase updateProductUseCase(UpdateProductOutputPort updateProductOutputPort, FindProductByIdInputPort findProductByIdInputPort){
        return new UpdateProductUseCase(updateProductOutputPort, findProductByIdInputPort);
    }
}
