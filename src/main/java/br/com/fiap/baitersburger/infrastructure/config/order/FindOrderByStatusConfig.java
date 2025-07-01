package br.com.fiap.baitersburger.infrastructure.config.order;

import br.com.fiap.baitersburger.application.usecase.order.impl.FindOrderByStatusUseCaseImpl;
import br.com.fiap.baitersburger.domain.port.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindOrderByStatusConfig {
    @Bean
    public FindOrderByStatusUseCaseImpl findOrderByStatusUseCase(OrderRepository orderRepository) {
        return new FindOrderByStatusUseCaseImpl(orderRepository);
    }
}
