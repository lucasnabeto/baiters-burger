package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.core.application.usecase.order.FindOrderByStatusUseCase;
import br.com.fiap.baitersburger.core.domain.ports.out.order.FindOrderByStatusOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindOrderByStatusConfig {
    @Bean
    public FindOrderByStatusUseCase findOrderByStatusUseCase(FindOrderByStatusOutputPort findOrderByStatusOutputPort) {
        return new FindOrderByStatusUseCase(findOrderByStatusOutputPort);
    }
}
