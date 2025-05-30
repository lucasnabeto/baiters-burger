package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.core.application.usecase.product.DeleteProductUseCase;
import br.com.fiap.baitersburger.core.application.ports.in.product.FindProductByIdInputPort;
import br.com.fiap.baitersburger.core.domain.ports.out.product.DeleteProductOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteProductConfig {
    @Bean
    public DeleteProductUseCase deleteProductUseCase(DeleteProductOutputPort deleteProductOutputPort, FindProductByIdInputPort findProductByIdInputPort){
        return new DeleteProductUseCase(deleteProductOutputPort, findProductByIdInputPort);
    }
}
