package br.com.fiap.baitersburger.infrastructure.config.product;

import br.com.fiap.baitersburger.core.application.usecase.product.FindProductByCategoryUseCase;
import br.com.fiap.baitersburger.core.domain.ports.out.product.FindProductByCategoryOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProductByCategoryConfig {
    @Bean
    public FindProductByCategoryUseCase findProductByCategoryUseCase(FindProductByCategoryOutputPort findProductByCategoryOutputPort){
        return new FindProductByCategoryUseCase(findProductByCategoryOutputPort);
    }
}
