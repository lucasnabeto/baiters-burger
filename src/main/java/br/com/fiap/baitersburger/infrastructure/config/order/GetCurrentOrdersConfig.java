package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.application.usecase.order.FindOrderByStatusUseCaseImpl;
import br.com.fiap.baitersburger.application.usecase.order.GetCurrentOrdersUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.FindOrderByStatusUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.OrderGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetCurrentOrdersConfig {
    @Bean
    public GetCurrentOrdersUseCaseImpl getCurrentOrdersUseCase(OrderGateway orderGateway) {
        return new GetCurrentOrdersUseCaseImpl(orderGateway);
    }


}
