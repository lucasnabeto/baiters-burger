package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.application.usecase.order.UpdateOrderStatusUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.in.usecase.order.UpdateOrderStatusUseCase;
import br.com.fiap.baitersburger.domain.port.out.gateway.OrderGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateOrderStatusConfig {
    @Bean
    public UpdateOrderStatusUseCase updateOrderStatusUseCase(OrderGateway orderGateway) {
        return new UpdateOrderStatusUseCaseImpl(orderGateway);
    }
}
