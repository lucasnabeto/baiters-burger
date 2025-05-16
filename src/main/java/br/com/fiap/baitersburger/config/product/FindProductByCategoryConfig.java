package br.com.fiap.baitersburger.config.product;

import br.com.fiap.baitersburger.application.core.usecase.product.FindProductByCategoryUseCase;
import br.com.fiap.baitersburger.application.ports.out.product.FindProductByCategoryOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProductByCategoryConfig {
    @Bean
    public FindProductByCategoryUseCase findProductByCategoryUseCase(FindProductByCategoryOutputPort findProductByCategoryOutputPort){
        return new FindProductByCategoryUseCase(findProductByCategoryOutputPort);
    }
}
