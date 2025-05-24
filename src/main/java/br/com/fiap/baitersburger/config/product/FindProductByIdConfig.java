package br.com.fiap.baitersburger.config.product;

import br.com.fiap.baitersburger.core.application.usecase.product.FindProductByIdUseCase;
import br.com.fiap.baitersburger.core.domain.ports.out.product.FindProductByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProductByIdConfig {
    @Bean
    public FindProductByIdUseCase findProductByIdUseCase(FindProductByIdOutputPort findProductByIdOutputPort){
        return new FindProductByIdUseCase(findProductByIdOutputPort);
    }
}
