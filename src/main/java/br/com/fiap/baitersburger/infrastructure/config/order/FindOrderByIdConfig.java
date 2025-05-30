package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.core.application.usecase.order.FindOrderByIdUseCase;
import br.com.fiap.baitersburger.core.domain.ports.out.order.FindOrderByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindOrderByIdConfig {
    @Bean
    public FindOrderByIdUseCase findOrderByIdUseCase(FindOrderByIdOutputPort findOrderByIdOutputPort) {
        return new FindOrderByIdUseCase(findOrderByIdOutputPort);
    }
}
