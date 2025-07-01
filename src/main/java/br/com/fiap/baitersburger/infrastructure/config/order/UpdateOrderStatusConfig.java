package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.application.usecase.order.impl.UpdateOrderStatusUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateOrderStatusConfig {
    @Bean
    public UpdateOrderStatusUseCaseImpl updateOrderStatusUseCase(
            OrderRepository orderRepository
    ) {
        return new UpdateOrderStatusUseCaseImpl(orderRepository);
    }
}
