package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.application.usecase.order.FindOrderByStatusUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.FindOrderByStatusUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.OrderGateway;
import br.com.fiap.baitersburger.domain.port.out.repository.OrderDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindOrderByStatusConfig {
    @Bean
    public FindOrderByStatusUseCase findOrderByStatusUseCase(OrderGateway orderGateway) {
        return new FindOrderByStatusUseCaseImpl(orderGateway);
    }


}
