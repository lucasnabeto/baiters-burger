package br.com.fiap.baitersburger.config.product;

import br.com.fiap.baitersburger.application.core.usecase.product.DeleteProductUseCase;
import br.com.fiap.baitersburger.application.ports.in.product.FindProductByIdInputPort;
import br.com.fiap.baitersburger.application.ports.out.product.DeleteProductOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteProductConfig {
    @Bean
    public DeleteProductUseCase deleteProductUseCase(DeleteProductOutputPort deleteProductOutputPort, FindProductByIdInputPort findProductByIdInputPort){
        return new DeleteProductUseCase(deleteProductOutputPort, findProductByIdInputPort);
    }
}
